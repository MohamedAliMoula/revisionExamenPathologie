package com.example.revisionexamen.Service.impl;

import com.example.revisionexamen.Entity.Patient;

public interface IServicePatient {
    Patient ajouterPatientEtAffecterAPathologie(Patient patient, String codePath);
}
