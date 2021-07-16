package org.cyrol.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cyrol.auth.model.Authority;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerAccountDto {

    private Long id;

    private String userId;

    private String username;

    private String email;

    private String password;

    private String name;

    private String operator;

    private String firstname;

    private boolean accountExpired;

    private boolean accountLocked;

    private boolean credentialsExpired;

    private boolean enabled;

    private LocalDateTime lastPasswordResetDate;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdatedDate;

//    @JsonIgnore
//    private Collection<Authority> authorities;
    private Set<Authority> authorities = new HashSet<>();

}
