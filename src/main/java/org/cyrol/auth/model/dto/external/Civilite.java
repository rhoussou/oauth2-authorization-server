package org.cyrol.auth.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Civilite {
    Mme("Mme"),
    M("M"),
    Mlle("Mlle");

    private String value;
}
