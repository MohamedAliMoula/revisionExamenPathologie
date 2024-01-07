package com.example.revisionexamen.Service.impl.impl;

import com.example.revisionexamen.Entity.FamilleActe;
import com.example.revisionexamen.Repository.FamilleActeRepository;
import com.example.revisionexamen.Service.impl.IServiceFamilleActe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceFamilleActe implements IServiceFamilleActe {
    private FamilleActeRepository familleActeRepository;
    @Override
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {
        return familleActeRepository.save(facte);
    }
}
