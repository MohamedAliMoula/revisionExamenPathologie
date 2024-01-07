package com.example.revisionexamen.Controller;

import com.example.revisionexamen.Entity.FamilleActe;
import com.example.revisionexamen.Entity.Pathologie;
import com.example.revisionexamen.Entity.Patient;
import com.example.revisionexamen.Service.impl.IServiceActe;
import com.example.revisionexamen.Service.impl.IServiceFamilleActe;
import com.example.revisionexamen.Service.impl.IServicePathologie;
import com.example.revisionexamen.Service.impl.IServicePatient;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AllController {
    IServicePathologie iServicePathologie;
    IServiceActe iServiceActe;
    IServiceFamilleActe iServiceFamilleActe;
    IServicePatient iServicePatient;

    @PostMapping("/addpathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie pathologie){
        return iServicePathologie.ajouterPathologie(pathologie);
    }

    @PostMapping("/addPatient/{codePath}")
    public Patient ajouterPatient(
            @RequestBody Patient patient,
            @PathVariable String codePath
    ){
        return iServicePatient.ajouterPatientEtAffecterAPathologie(patient, codePath);
    }

    @PostMapping("/addFamille")
    public FamilleActe ajouterFamilleActe(@RequestBody FamilleActe familleActe){
        return iServiceFamilleActe.ajouterFamilleActeEtActeAssocie(familleActe);
    }

    @PutMapping("/affecteracte")
    public void affecterActe(@RequestParam String codeActe,@RequestParam String codePath) {
        iServiceActe.affecterActeAPathologie(codeActe, codePath);
    }

    @GetMapping("/calculefacture/{identifiant}")
    public float calculeFacture(@PathVariable String identifiant) {
        return iServicePathologie.calculerFacture(identifiant);
    }
}
