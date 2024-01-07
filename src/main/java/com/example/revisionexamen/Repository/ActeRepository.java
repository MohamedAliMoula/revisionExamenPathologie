package com.example.revisionexamen.Repository;

import com.example.revisionexamen.Entity.Acte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeRepository extends JpaRepository<Acte, Long> {
    Acte findByCodeActe(String codeActe);
}
