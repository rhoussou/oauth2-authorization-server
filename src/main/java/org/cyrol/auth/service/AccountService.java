package org.cyrol.auth.service;


import org.cyrol.auth.model.OauthClient;
import org.cyrol.auth.repository.CustomerAccountRepository;
import org.cyrol.auth.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	/**
	 * cette façon de faire permet d'utiliser plusieurs table de compte
	 * on se base sur le ClientID pour savoir quelle table interroger
	 * l'objectif ici est d'avoir un seul serveur d'auth quelque soit l'interface utilisateur .(clientUI pour le back, customerUI pour les autres)
	 * clientUI se connecte via username et customerUI utilise email
	 * @param username
	 * @return UserDetails
	 * @throws UsernameNotFoundException
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails account;
		//recuperation nom du client Oauth
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		User oauthClient = (User) authentication.getPrincipal();
		if (OauthClient.clientUI.getValue().equals(oauthClient.getUsername())) {
			account = userAccountRepository.findByUsername(username);
		} else {
			account = customerAccountRepository.findByEmail(username);
		}
		if (account != null) {
			return account;
		}
		throw new UsernameNotFoundException(username);
	}



}