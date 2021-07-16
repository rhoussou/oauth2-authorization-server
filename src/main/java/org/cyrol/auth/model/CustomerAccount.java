package org.cyrol.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Account", uniqueConstraints = { @UniqueConstraint(columnNames = { "USERNAME" }) })
public class CustomerAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_ID", unique = true, nullable = false)
    String accountId =  UUID.randomUUID().toString();

    @Column(name = "USERNAME")
    private String username;

    @NonNull
    @NotNull(message = "email can not be null.")
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountExpired;

    @Column(name = "ACCOUNT_LOCKED")
    private boolean accountLocked;

    @Column(name = "CREDENTIALS_EXPIRED")
    private boolean credentialsExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    private LocalDateTime lastPasswordResetDate;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime lastUpdatedDate = LocalDateTime.now();

    @Column(name = "OPERATOR")
    private String operator;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "CUSTOMER_ACCOUNT_AUTHORITIES", joinColumns = @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID"))
    private Set<Authority> authorities = new HashSet<>();;

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }


    public void addAuthority(Set<Authority> authorities) {
        authorities.forEach(authority -> {
            this.authorities.add(authority);
            authority.getCustomerAccounts().add(this);
        });
    }

    public void removeAuthority(Authority authority) {
        authorities.remove(authority);
        authority.getCustomerAccounts().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerAccount)) return false;
        return id != null && id.equals(((CustomerAccount) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
