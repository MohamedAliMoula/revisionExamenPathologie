package com.example.revisionexamen.Repository;

import com.example.revisionexamen.Entity.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologieRepository extends JpaRepository<Pathologie, Long> {
    Pathologie findByCodePath(String codePath);

    @Query("select p from Pathologie p where p.libelle = :id or p.codePath = :id")
    Pathologie findByCodePathOrLibelleCustom(String id);
}
