package org.cyrol.auth.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatutResidence {

    PROPRIETAIRE("PROPRIETAIRE"),
    LOCATAIRE("LOCATAIRE"),
    HEBERGE_FAMILLE("HEBERGE_FAMILLE"),
    HEBERGE_EMPLOYEUR("HEBERGE_EMPLOYEUR"),
    HEBERGE_TIERS("HEBERGE_TIERS"),
    AUTRE("AUTRE");

    private String value;

}