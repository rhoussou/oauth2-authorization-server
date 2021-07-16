package org.cyrol.auth.repository;


import org.cyrol.auth.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

	@Query("SELECT DISTINCT account FROM UserAccount account " +
			"INNER JOIN FETCH account.authorities AS authorities " +
			"WHERE account.username = :username")
    UserAccount findByUsername(@Param("username") String username);

	@Query("SELECT DISTINCT account FROM UserAccount account " +
			"INNER JOIN FETCH account.authorities AS authorities " +
			"WHERE account.email = :email")
    UserAccount findByEmail(@Param("email") String email);

	UserAccount findByAccountId(String accountId);

	boolean existsByEmail(String email);
}
