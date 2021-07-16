package org.cyrol.auth.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private String userId =  UUID.randomUUID().toString();

    private Civilite civilite;

    private String email;

    private String password;

    private String nom;

    private String nomsAlt;

    private String prenom;

    private String prenomsAlt;

    private Sexe sexe;

    private boolean celibataire;

    private LocalDate deces;

    private String nationalite;

    private NaissanceCustomer naissance;

    private Media contact;

    private Collection<Residence> residences;

    private Collection<Activite> activites;

    private Collection<Bank> banks;
}
