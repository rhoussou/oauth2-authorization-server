
package org.cyrol.auth.api;


import org.cyrol.auth.model.dto.CustomerAccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

public interface CustomerAccountApi {


    @RequestMapping(value = "/customer/accounts/{accountId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Object> delUser(@PathVariable("accountId") String idUser);


    @RequestMapping(value = "/customer/accounts/{accountId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<CustomerAccountDto> getCustomerAccount(@PathVariable("accountId") String accountId);

    @RequestMapping(value = "/customer/accounts",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<CustomerAccountDto> addCustomerAccount(@Valid @RequestBody CustomerAccountDto customerAccountDto);

    @RequestMapping(value = "/customer/accounts",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<CustomerAccountDto>> listCustomerAccount(@Valid @RequestParam(value = "page_size", required = false, defaultValue="15") Integer pageSize,
                                                         @Valid @RequestParam(value = "page", required = false, defaultValue="1") Integer page,
                                                         @Valid @RequestParam(value = "sort_dir", required = false, defaultValue="DESC") String sortDir,
                                                         @Valid @RequestParam(value = "sort", required = false) String sort);


    @RequestMapping(value = "/customer/accounts/{accountId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<CustomerAccountDto> updateCustomerAccount(@PathVariable("accountId") String accountId, @Valid @RequestBody CustomerAccountDto customerAccountDto);



    @RequestMapping(value = "/customer/accounts/{accountId}/changepwd",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<CustomerAccountDto> changeCustomerAccountPassword (@PathVariable("accountId") String accountId, @Valid @RequestBody CustomerAccountDto customerAccountDto);

}
