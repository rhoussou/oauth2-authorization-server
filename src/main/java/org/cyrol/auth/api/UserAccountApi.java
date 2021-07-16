
package org.cyrol.auth.api;


import org.cyrol.auth.model.dto.UserAccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

public interface UserAccountApi {


    @RequestMapping(value = "/user/accounts",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<UserAccountDto> addUserAccount(@Valid @RequestBody UserAccountDto userAccountDto);


    @RequestMapping(value = "/user/accounts/{accountId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Object> delUser(@PathVariable("accountId") String idUser);


    @RequestMapping(value = "/user/accounts/me",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserAccountDto> getCurrentUserAccount();


    @RequestMapping(value = "/user/accounts/{accountId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserAccountDto> getUserAccount(@PathVariable("accountId") String accountId);

    @RequestMapping(value = "/user/accounts",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<UserAccountDto>> listUserAccount(@Valid @RequestParam(value = "page_size", required = false, defaultValue = "15") Integer pageSize,
                                                         @Valid @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                         @Valid @RequestParam(value = "sort_dir", required = false, defaultValue = "DESC") String sortDir,
                                                         @Valid @RequestParam(value = "sort", required = false) String sort);


    @RequestMapping(value = "/user/accounts/{accountId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<UserAccountDto> updateUserAccount(@PathVariable("accountId") String accountId, @Valid @RequestBody UserAccountDto userAccountDto);


    @RequestMapping(value = "/user/accounts/{accountId}/changepwd",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<UserAccountDto> changeUserAccountPassword(@PathVariable("accountId") String accountId, @Valid @RequestBody UserAccountDto userAccountDto);
}