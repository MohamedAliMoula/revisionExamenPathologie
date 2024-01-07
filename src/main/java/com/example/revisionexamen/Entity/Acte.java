package com.example.revisionexamen.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idActe;
    private String codeActe;
    private int cotationActe;
    private float prixUnitaireActe;
    private String designationActe;

    @ManyToOne()
    private FamilleActe familleActe;

    @ManyToMany(mappedBy = "actes")
    private List<Pathologie> pathologies;
}
