package org.cyrol.auth.repository;

import org.cyrol.auth.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String> {

	@Query("SELECT DISTINCT account FROM CustomerAccount account " +
			"INNER JOIN FETCH account.authorities AS authorities " +
			"WHERE account.username = :username")
    CustomerAccount findByUsername(@Param("username") String username);

	@Query("SELECT DISTINCT account FROM CustomerAccount account " +
			"INNER JOIN FETCH account.authorities AS authorities " +
			"WHERE account.email = :email")
	CustomerAccount findByEmail(@Param("email") String email);

	CustomerAccount findByAccountId(String accountId);

	boolean existsByEmail(String email);
}
