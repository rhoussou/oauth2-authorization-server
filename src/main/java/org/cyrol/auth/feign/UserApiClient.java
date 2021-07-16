package org.cyrol.auth.feign;

import org.cyrol.auth.model.dto.external.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface UserApiClient {

    @PostMapping(value = "uaa/users")
    ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userRequest);


    @RequestMapping(value = "/users/email/{email}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email);

    @RequestMapping(value = "/users/username/{username}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<UserDto> getUserByUsername(@PathVariable("username") String username);
}
