package org.cyrol.auth.service;


import org.cyrol.auth.model.UserAccount;

import java.util.List;


public interface UserAccountService {

	UserAccount createUserAccount(UserAccount userAccount);

	List<UserAccount> getAllUserAccounts(int pageNumber, int pageSize, String sortDir, String sort);

	UserAccount getUserAccount(String accountId);

	UserAccount getUserAccountByUsername(String username);

	UserAccount getUserAccountByEmail(String email);
	
	UserAccount updateUserAccount(UserAccount userAccount);

	void deleteUserAccount(String accountId);

	void deleteCustomerAccount(String accountId);

	boolean checkIfIdexists(String id);

	boolean checkIfEmailExists(String email);
}
