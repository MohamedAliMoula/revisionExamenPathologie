package com.example.revisionexamen.Service.impl.impl;

import com.example.revisionexamen.Entity.Acte;
import com.example.revisionexamen.Entity.Pathologie;
import com.example.revisionexamen.Repository.PathologieRepository;
import com.example.revisionexamen.Service.impl.IServicePathologie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;

@Service
@AllArgsConstructor
@Slf4j
public class ServicePathologieImpl implements IServicePathologie {
    private PathologieRepository pathologieRepository;
    @Override
    public Pathologie ajouterPathologie(Pathologie pathologie) {
        pathologie.setActes(new ArrayList<>());
        return pathologieRepository.save(pathologie);
    }

    @Override
    public float calculerFacture(String identifiant) {
        Pathologie pathologie = pathologieRepository.findByCodePathOrLibelleCustom(identifiant);
        if(!pathologie.isArchive()){
            float sum = 0;
            for (Acte acte : pathologie.getActes()) {
                sum += (acte.getPrixUnitaireActe() * acte.getCotationActe());
            }
            return sum;
        }else {
            return -1;
        }
    }

    @Override
    @Scheduled(fixedDelay = 5000)
    public void calculerNombreActesParPathologie() {
        List<Pathologie> ls = pathologieRepository.findAll();
        for(Pathologie path: ls){
            log.info("pathologie: " + path.getLibelle() + " nb actes: " + path.getActes().size());
        }
    }
}
