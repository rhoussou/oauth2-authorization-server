package org.cyrol.auth.resource;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import org.cyrol.auth.api.UserAccountApi;
import org.cyrol.auth.feign.UserApiClient;
import org.cyrol.auth.model.Authority;
import org.cyrol.auth.model.UserAccount;
import org.cyrol.auth.model.dto.UserAccountDto;
import org.cyrol.auth.service.AuthorityService;
import org.cyrol.auth.service.UserAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserAccountResource implements UserAccountApi {

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private PasswordEncoder userPasswordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserApiClient userApiClient;

	@Override
	public ResponseEntity<UserAccountDto> addUserAccount(UserAccountDto userAccountDto) {

		if (userAccountService.checkIfEmailExists(userAccountDto.getEmail())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		UserAccount newUserAccount = new UserAccount();
		newUserAccount.setEmail(userAccountDto.getEmail());
		newUserAccount.setUsername(userAccountDto.getUsername());
		newUserAccount.setEnabled(true);
		newUserAccount.setLastUpdatedDate(LocalDateTime.now());
		newUserAccount.setCreatedDate(LocalDateTime.now());
		newUserAccount.setAccountExpired(false);
		newUserAccount.setAccountLocked(false);
		Set<Authority> roles = userAccountDto.getAuthorities();
		if(CollectionUtils.isEmpty(roles)) {
			roles = Collections.singleton(authorityService.getAuthorityByName("COMMERCIAL"));
		}
		newUserAccount.addAuthority(roles);
		newUserAccount.setPassword(userPasswordEncoder.encode(userAccountDto.getPassword()));
		UserAccount userAccountResponse = userAccountService.createUserAccount(newUserAccount);
		if (userAccountResponse != null) {
			UserAccountDto userResponseDto = modelMapper.map(userAccountResponse, UserAccountDto.class);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(userResponseDto);
		}
		return ResponseEntity
				.status(HttpStatus.NOT_MODIFIED)
		        .body(null);
	}


	@Override
	public ResponseEntity<UserAccountDto> getUserAccount(String accountId) {
		UserAccount userAccount = userAccountService.getUserAccount(accountId);
		if (userAccount != null) {
			UserAccountDto userResponseDto = modelMapper.map(userAccount, UserAccountDto.class);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(userResponseDto);
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}


	@Override
	public ResponseEntity<List<UserAccountDto>> listUserAccount(Integer pageSize, Integer page, String sortDir, String sort) {
		List<UserAccountDto> response = userAccountService.getAllUserAccounts(page,pageSize,sortDir, sort).stream()
				.map(u -> modelMapper.map(u, UserAccountDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserAccountDto> updateUserAccount(String accountId, UserAccountDto updateRequest) {
		UserAccount userAccount = userAccountService.getUserAccount(accountId);
		if (userAccount != null) {
			userAccount.setUsername(updateRequest.getUsername());
			userAccount.setEmail(updateRequest.getEmail());
			userAccount.setEnabled(updateRequest.isEnabled());
			userAccount.setAuthorities(updateRequest.getAuthorities());
			userAccount.setAccountLocked(updateRequest.isAccountLocked());
			userAccount.setLastUpdatedDate(LocalDateTime.now());
			UserAccount userAccountUpdated = userAccountService.updateUserAccount(userAccount);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(modelMapper.map(userAccountUpdated, UserAccountDto.class));
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}

	@Override
	public ResponseEntity<Object> delUser(String accountId) {
		return null;
	}


	@Override
	public ResponseEntity<UserAccountDto> getCurrentUserAccount() {

		String username ="me";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}

		UserAccountDto response = modelMapper.map(userApiClient.getUserByUsername(username), UserAccountDto.class);

		//UserAccountDto response = modelMapper.map(userAccountService.getUserAccountByUsername(username), UserAccountDto.class);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}

	@Override
	public ResponseEntity<UserAccountDto> changeUserAccountPassword(String accountId, UserAccountDto updateRequest) {
		UserAccount userAccount = userAccountService.getUserAccount(accountId);
		if (userAccount != null) {
			userAccount.setPassword(userPasswordEncoder.encode(updateRequest.getPassword()));
			userAccount.setLastPasswordResetDate(LocalDateTime.now());
			UserAccount userAccountUpdated = userAccountService.updateUserAccount(userAccount);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(modelMapper.map(userAccountUpdated, UserAccountDto.class));
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(null);
	}
//	@Override
//	public Principal userAccount(Principal userAccount) {
//		return userAccount;
//	}

}