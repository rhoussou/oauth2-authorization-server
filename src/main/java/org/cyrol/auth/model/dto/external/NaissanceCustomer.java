package org.cyrol.auth.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Embeddable
public class NaissanceCustomer {

    private String nomDeNaissance;

    private LocalDate dateNaissance;

    private String pays;

    private String ville;

    private String codePostal;

    private String departement;

}
