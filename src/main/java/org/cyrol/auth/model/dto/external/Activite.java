package org.cyrol.auth.model.dto.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String  activityId =  UUID.randomUUID().toString();

    private TypeActivite type;

    private String profession;

    private CategorieSocioProfessionnelle catSocio;

    private LocalDate debut;

    private LocalDate fin;

    private TypeContrat typeContrat;

    private boolean periodeEssaiValidee;

    private boolean principale;

    private String paysExercice;

    @Embedded
    private Employeur employeur;

}
