package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Usage {

    PERSONNEL("PERSONNEL"),
    PROFESSIONNEL("PROFESSIONEL");


    private String value;



}
