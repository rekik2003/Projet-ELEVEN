package com.mycompany.app.event_organization.controllers;

import com.mycompany.app.event_organization.entity.Affectation;
import com.mycompany.app.event_organization.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/personnels")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @PostMapping("mesAffectations")
    public ResponseEntity<List<Affectation>> afficherAffectations(@RequestBody int idPersonnel) {
        List<Affectation> affectations = personnelService.afficherAffectations(idPersonnel);
        return ResponseEntity.status(HttpStatus.OK).body(affectations);
    }
}
