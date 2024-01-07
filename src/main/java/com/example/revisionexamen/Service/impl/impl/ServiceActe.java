package com.example.revisionexamen.Service.impl.impl;

import com.example.revisionexamen.Entity.Acte;
import com.example.revisionexamen.Entity.Pathologie;
import com.example.revisionexamen.Repository.ActeRepository;
import com.example.revisionexamen.Repository.PathologieRepository;
import com.example.revisionexamen.Service.impl.IServiceActe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceActe implements IServiceActe {
    private ActeRepository acteRepository;
    private PathologieRepository pathologieRepository;
    @Override
    public void affecterActeAPathologie(String codeActe, String codePathologie) {
        Pathologie pathologie = pathologieRepository.findByCodePath(codePathologie);
        if(!pathologie.isArchive()){
            Acte acte = acteRepository.findByCodeActe(codeActe);
            List<Pathologie> lspath = acte.getPathologies();
            List<Acte> lsacte = pathologie.getActes();
            lspath.add(pathologie);
            acte.setPathologies(lspath);
            lsacte.add(acte);
            pathologie.setActes(lsacte);

            pathologieRepository.save(pathologie);
            acteRepository.save(acte);
        }
    }
}
