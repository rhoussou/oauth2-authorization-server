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
/*lieux de residence du client*/
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String  residenceId =  UUID.randomUUID().toString();

    @Embedded
    private Adresse adresse;

    private StatutResidence statut;

    private LocalDate dateEntre;

}
