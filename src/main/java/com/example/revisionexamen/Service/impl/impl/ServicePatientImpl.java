package com.example.revisionexamen.Service.impl.impl;

import com.example.revisionexamen.Entity.Pathologie;
import com.example.revisionexamen.Entity.Patient;
import com.example.revisionexamen.Repository.PathologieRepository;
import com.example.revisionexamen.Repository.PatientRepository;
import com.example.revisionexamen.Service.impl.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatientImpl implements IServicePatient {
    private PatientRepository patientRepository;
    private PathologieRepository pathologieRepository;
    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient patient, String codePath) {
        List<Pathologie> pathologieList = new ArrayList<>();
        Pathologie path = pathologieRepository.findByCodePath(codePath);
        pathologieList.add(path);
        patient.setPathologies(pathologieList);
        return patientRepository.save(patient);
    }
}
