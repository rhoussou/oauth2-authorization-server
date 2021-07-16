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
public class Domiciliation {

    private String nomBanque;

    private String titulaire;

    private String bic;

    @Embedded
    private Adresse adresse;
}