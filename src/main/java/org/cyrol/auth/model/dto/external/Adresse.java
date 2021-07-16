package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Embeddable
public class Adresse {

    private AdresseUsage usage;

    private String numero;

    private String voie;

    private String complement;

    private String libelle;

    private String lieuDit;

    private String etage;

    private String codePostal;

    private String ville;

    private String pays;

}
