package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String  bankId =  UUID.randomUUID().toString();

    private boolean principal;

    private String numeroDeCompte;

    private TypeCompte typeDeCompte;

    private String iban;

    @Embedded
    private Domiciliation domiciliation;

    private LocalDate ouverture;

    private String devise;
}
