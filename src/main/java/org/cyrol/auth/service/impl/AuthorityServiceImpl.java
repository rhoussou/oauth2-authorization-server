package org.cyrol.auth.service.impl;


import org.apache.commons.lang.StringUtils;
import org.cyrol.auth.model.Authority;
import org.cyrol.auth.repository.AuthorityRepository;
import org.cyrol.auth.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {


    @Autowired
    private AuthorityRepository authorityRepository;

	@Override
	public Authority create(Authority authority) {
		return authorityRepository.save(authority);
	}

	@Override
	public List<Authority> getAllAuthority(int pageNumber, int pageSize, String sortDir, String sort) {
		if (StringUtils.isEmpty(sortDir)){
			sortDir = "DESC";
		}
		if (StringUtils.isEmpty(sort)){
			sort = "username";
		}
		PageRequest pageReq = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDir), sort);
		return this.authorityRepository.findAll(pageReq).getContent();
	}

	@Override
	public Authority getAuthorityByName(String name) {
		return authorityRepository.findByName(name);
	}

	@Override
	public boolean checkIfNameExists(String name) {
		return authorityRepository.existsByName(name);
	}

}
