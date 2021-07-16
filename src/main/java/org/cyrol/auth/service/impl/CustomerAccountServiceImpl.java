package org.cyrol.auth.service.impl;


import org.apache.commons.lang.StringUtils;
import org.cyrol.auth.model.CustomerAccount;
import org.cyrol.auth.repository.CustomerAccountRepository;
import org.cyrol.auth.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {


	@Autowired
	private CustomerAccountRepository customerAccountRepository;


	@Override
	public boolean checkIfIdexists(String id) {
		return customerAccountRepository.existsById(id);
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		return customerAccountRepository.existsByEmail(email);
	}

	@Override
	@Transactional
	public CustomerAccount createCustomerAccount(CustomerAccount customerAccount) {
		return customerAccountRepository.save(customerAccount);
	}

	@Override
	public List<CustomerAccount> getAllCustomerAccounts(int pageNumber, int pageSize, String sortDir, String sort) {
		if (StringUtils.isEmpty(sortDir)){
			sortDir = "DESC";
		}
		if (StringUtils.isEmpty(sort)){
			sort = "username";
		}
		PageRequest pageReq = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDir), sort);
		return this.customerAccountRepository.findAll(pageReq).getContent();
	}

	@Override
	public CustomerAccount getCustomerAccount(String accountId) {
		return customerAccountRepository.findByAccountId(accountId);
	}

	@Override
	public CustomerAccount getCustomerAccountByEmail(String email) {
		return customerAccountRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public CustomerAccount updateCustomerAccount(CustomerAccount updtedCustomerAccount) {
		return customerAccountRepository.save(updtedCustomerAccount);
	}

	@Override
	@Transactional
	public void deleteCustomerAccount(String accountId) {
		CustomerAccount customerAccount = customerAccountRepository.findByAccountId(accountId);
		customerAccountRepository.delete(customerAccount);

	}
}