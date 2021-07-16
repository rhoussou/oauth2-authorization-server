package org.cyrol.auth.resource;

import org.cyrol.auth.api.CustomerAccountApi;
import org.cyrol.auth.feign.UserApiClient;
import org.cyrol.auth.model.Authority;
import org.cyrol.auth.model.CustomerAccount;
import org.cyrol.auth.model.dto.CustomerAccountDto;
import org.cyrol.auth.service.AuthorityService;
import org.cyrol.auth.service.CustomerAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class CustomerAccountResource implements CustomerAccountApi {


	@Autowired
	private CustomerAccountService customerAccountService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private PasswordEncoder userPasswordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserApiClient userApiClient;

	@Override
	public ResponseEntity<CustomerAccountDto> addCustomerAccount(@Valid CustomerAccountDto customerAccountDto) {
		if (customerAccountService.checkIfEmailExists(customerAccountDto.getEmail())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		CustomerAccount newCustomerAccount = new CustomerAccount();
		newCustomerAccount.setEmail(customerAccountDto.getEmail());
		newCustomerAccount.setUsername(customerAccountDto.getUsername());
		newCustomerAccount.setEnabled(true);
		newCustomerAccount.setLastUpdatedDate(LocalDateTime.now());
		newCustomerAccount.setCreatedDate(LocalDateTime.now());
		newCustomerAccount.setAccountExpired(false);
		newCustomerAccount.setAccountLocked(false);
		Set<Authority> roles = customerAccountDto.getAuthorities();
		if(CollectionUtils.isEmpty(roles)) {
			roles = Collections.singleton(authorityService.getAuthorityByName("CUSTOMER"));
		}
		newCustomerAccount.addAuthority(roles);
		newCustomerAccount.setPassword(userPasswordEncoder.encode(customerAccountDto.getPassword()));
		CustomerAccount customerAccountResponse = customerAccountService.createCustomerAccount(newCustomerAccount);
		if (customerAccountResponse != null) {
			CustomerAccountDto customerAccountResponseDto = modelMapper.map(customerAccountResponse, CustomerAccountDto.class);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(customerAccountResponseDto);
		}
		return ResponseEntity
				.status(HttpStatus.NOT_MODIFIED)
				.body(null);
	}


	@Override
	public ResponseEntity<Object> delUser(String accountId) {
		return null;
	}


	@Override
	public ResponseEntity<CustomerAccountDto> getCustomerAccount(String accountId) {
		CustomerAccount customerAccount = customerAccountService.getCustomerAccount(accountId);
		if (customerAccount != null) {
			CustomerAccountDto customerAccountResponseDto = modelMapper.map(customerAccount, CustomerAccountDto.class);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(customerAccountResponseDto);
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}

	@Override
	public ResponseEntity<List<CustomerAccountDto>> listCustomerAccount(@Valid Integer pageSize, @Valid Integer page, @Valid String sortDir, @Valid String sort) {
		List<CustomerAccountDto> response = customerAccountService.getAllCustomerAccounts(page,pageSize,sortDir, sort).stream()
				.map(u -> modelMapper.map(u, CustomerAccountDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CustomerAccountDto> updateCustomerAccount(String accountId, @Valid CustomerAccountDto customerAccountDto) {
		CustomerAccount customerAccount = customerAccountService.getCustomerAccount(accountId);
		if (customerAccount != null) {
			customerAccount.setUsername(customerAccountDto.getUsername());
			customerAccount.setEmail(customerAccountDto.getEmail());
			customerAccount.setEnabled(customerAccountDto.isEnabled());
			customerAccount.setAuthorities(customerAccountDto.getAuthorities());
			customerAccount.setAccountLocked(customerAccountDto.isAccountLocked());
			customerAccount.setLastUpdatedDate(LocalDateTime.now());
			CustomerAccount customerAccountUpdated = customerAccountService.updateCustomerAccount(customerAccount);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(modelMapper.map(customerAccountUpdated, CustomerAccountDto.class));
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}

	@Override
	public ResponseEntity<CustomerAccountDto> changeCustomerAccountPassword(String accountId, @Valid CustomerAccountDto customerAccountDto) {
		CustomerAccount customerAccount = customerAccountService.getCustomerAccount(accountId);
		if (customerAccount != null) {
			customerAccount.setPassword(userPasswordEncoder.encode(customerAccountDto.getPassword()));
			customerAccount.setLastPasswordResetDate(LocalDateTime.now());
			CustomerAccount customerAccountUpdated = customerAccountService.updateCustomerAccount(customerAccount);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(modelMapper.map(customerAccountUpdated, CustomerAccountDto.class));
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}
}