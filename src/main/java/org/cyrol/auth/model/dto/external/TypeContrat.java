package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TypeContrat {

    CDI("CDI"),
    CDD("CDD"),
    INTERIMAIRE("INTERIMAIRE"),
    INTERMITTENT("INTERMITTENT"),
    CESU("CESU"),
    TITULAIRE_FONCTION_PUBLIQUE("TITULAIRE_FONCTION_PUBLIQUE"),
    STAGIAIRE_FONCTION_PUBLIQUE("STAGIAIRE_FONCTION_PUBLIQUE"),
    CONTRACTUEL_FONCTION_PUBLIQUE("CONTRACTUEL_FONCTION_PUBLIQUE"),
    APPRENTISSAGE("APPRENTISSAGE"),
    STAGE("STAGE"),
    AIDE("AIDE"),
    SANS_CONTRAT("SANS_CONTRAT");

    private String value;

}
