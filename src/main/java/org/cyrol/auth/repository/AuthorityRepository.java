package org.cyrol.auth.repository;


import org.cyrol.auth.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
	Authority findByName(String name);

	boolean existsByName(String name);
}
