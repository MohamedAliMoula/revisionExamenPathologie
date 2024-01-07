package com.example.revisionexamen.Repository;

import com.example.revisionexamen.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
