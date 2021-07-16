package org.cyrol.auth.service;

import org.cyrol.auth.model.CustomerAccount;
import java.util.List;


public interface CustomerAccountService {


	CustomerAccount createCustomerAccount(CustomerAccount customerAccount);

	List<CustomerAccount> getAllCustomerAccounts(int pageNumber, int pageSize, String sortDir, String sort);

	CustomerAccount getCustomerAccount(String accountId);

	CustomerAccount getCustomerAccountByEmail(String email);

	CustomerAccount updateCustomerAccount(CustomerAccount customerAccount);

	void deleteCustomerAccount(String accountId);

	boolean checkIfIdexists(String id);

	boolean checkIfEmailExists(String email);
}
