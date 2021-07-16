package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Embeddable
public class Employeur {

    private String raisonSociale;

    private String siren;

    private String siret;

    @Embedded
    private Adresse adresse;

}
