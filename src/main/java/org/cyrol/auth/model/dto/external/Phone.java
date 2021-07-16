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
public class Phone {

    private Usage usage;

    private TypePhone type;

    private String codePays;

    private String prefixNational;

    private String numeroTel;
}
