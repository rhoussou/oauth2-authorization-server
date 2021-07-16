
package org.cyrol.auth.api;


import org.cyrol.auth.model.dto.CustomerAccountDto;
import org.cyrol.auth.model.dto.UserAccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

public interface AccountApi {



    @RequestMapping("/user")
    @ResponseBody
    Principal userAccount(Principal user);

}
