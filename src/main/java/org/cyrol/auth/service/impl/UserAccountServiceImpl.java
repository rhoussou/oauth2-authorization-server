package org.cyrol.auth.service.impl;


import org.apache.commons.lang.StringUtils;
import org.cyrol.auth.model.UserAccount;
import org.cyrol.auth.repository.UserAccountRepository;
import org.cyrol.auth.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;


    @Override
	@Transactional
	public UserAccount createUserAccount(UserAccount userAccount) {
		return userAccountRepository.save(userAccount);
	}

	@Override
	@Transactional
	public UserAccount getUserAccountByUsername(String username) {
		return userAccountRepository.findByUsername(username);
	}

	@Override
	public UserAccount getUserAccountByEmail(String email) {
		return userAccountRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public UserAccount updateUserAccount(UserAccount updtedUserAccount) {
		return userAccountRepository.save(updtedUserAccount);
	}

    @Override
    @Transactional
    public void deleteUserAccount(String accountId) {
		UserAccount userAccount = userAccountRepository.findByAccountId(accountId);
		userAccountRepository.delete(userAccount);
    }

	@Override
	public void deleteCustomerAccount(String accountId) {

	}

	@Override
	public boolean checkIfIdexists(String id) {
		return userAccountRepository.existsById(id);
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		return userAccountRepository.existsByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
    public List<UserAccount> getAllUserAccounts(int pageNumber, int pageSize, String sortDir, String sort) {
		if (StringUtils.isEmpty(sortDir)){
			sortDir = "DESC";
		}
		if (StringUtils.isEmpty(sort)){
			sort = "username";
		}
		PageRequest pageReq = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDir), sort);
		return this.userAccountRepository.findAll(pageReq).getContent();
	}

	@Override
	public UserAccount getUserAccount(String accountId) {
		return userAccountRepository.findByAccountId(accountId);
	}





}