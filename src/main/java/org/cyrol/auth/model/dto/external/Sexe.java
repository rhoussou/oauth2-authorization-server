package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sexe {
    HOMME("HOMME"),
    FEMME("FEMME"),
    AUTRE("AUTRE");

    private String value;
}
