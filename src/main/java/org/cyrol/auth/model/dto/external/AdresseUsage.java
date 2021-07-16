package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AdresseUsage {

    DEFAUT("DEFAUT"),
    CONTACT("CONTACT"),
    FACTURATION("FACTURATION"),
    LIVRAISON("LIVRAISON"),
    AUTRE("AUTRE");


    private String value;
}
