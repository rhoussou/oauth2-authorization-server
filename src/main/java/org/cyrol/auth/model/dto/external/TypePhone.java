package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypePhone {

    FAX("FAX"),
    HOME("HOME"),
    MOBILE("MOBILE"),
    AUTRE("AUTRE"),
    PAGER("PAGER");

    private String value;
}