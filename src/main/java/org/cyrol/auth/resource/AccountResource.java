package org.cyrol.auth.resource;

import java.security.Principal;
import org.cyrol.auth.api.AccountApi;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountResource implements AccountApi {

	@Override
	public Principal userAccount(Principal userAccount) {
		return userAccount;
	}

}