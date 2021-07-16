package org.cyrol.auth.service;


import org.cyrol.auth.model.Authority;

import java.util.List;


public interface AuthorityService {

	Authority create(Authority authority);

	List<Authority> getAllAuthority(int pageNumber, int pageSize, String sortDir, String sort);

	Authority getAuthorityByName(String name);

	boolean checkIfNameExists(String name);
}
