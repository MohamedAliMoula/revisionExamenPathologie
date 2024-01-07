package com.example.revisionexamen.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPatient;
    @Enumerated(EnumType.STRING)
    private TypePieceIdentite typePieceIdentite;
    private String identifiantPierceIdentite;
    private Date dateEmission;
    private String nomP;
    private String prenomP;

    @ManyToMany()
    private List<Pathologie> pathologies;
}
