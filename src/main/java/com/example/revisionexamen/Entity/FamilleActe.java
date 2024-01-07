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
public class FamilleActe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFA;
    private String codeFA;
    private String libelle;
    private String description;

    @OneToMany(mappedBy = "familleActe", cascade = CascadeType.PERSIST)
    private List<Acte> actes;
}
