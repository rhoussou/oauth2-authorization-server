package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeCompte {

    PARTICULIER_INDIVIDUEL("PARTICULIER_INDIVIDUEL"),
    PARTICULIER_JOINT("PARTICULIER_JOINT"),
    PROFESSIONNEL("PROFESSIONNEL");

    private String value;
}
