package com.example.revisionexamen.Service.impl;

import com.example.revisionexamen.Entity.Pathologie;

public interface IServicePathologie {
    Pathologie ajouterPathologie(Pathologie pathologie);
    float calculerFacture(String identifiant);
    void calculerNombreActesParPathologie();

}
