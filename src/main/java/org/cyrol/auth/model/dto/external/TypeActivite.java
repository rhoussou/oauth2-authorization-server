package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeActivite {

    SALARIE_DU_PRIVE("SALARIE DU PRIVE"),
    SALARIE_DU_PUBLIC("SALARIE DU PUBLIC") ,
    NON_SALARIE("NON SALARIE"),
    RENTIER("RENTIER"),
    RETRAITE("RETRAITE"),
    SANS_ACTIVITE_PROFESSIONNELLE("SANS ACTIVITE PROFESSIONNELLE");

    private String value;
}
