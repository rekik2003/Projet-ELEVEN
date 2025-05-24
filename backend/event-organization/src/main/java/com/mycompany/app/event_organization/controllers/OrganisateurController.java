package com.mycompany.app.event_organization.controllers;

import com.mycompany.app.event_organization.entity.Match;
import com.mycompany.app.event_organization.entity.Personnel;
import com.mycompany.app.event_organization.services.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/organisateur")
public class OrganisateurController {

    @Autowired
    private OrganisateurService organisateurService;
    @PostMapping("/listePersonnels/{position}")
    public ResponseEntity<List<Personnel>> afficherPersonnelsDisponibles(@RequestBody XMLGregorianCalendar date , @PathVariable String position) throws DatatypeConfigurationException {
        List<Personnel> personnels = organisateurService.afficherPersonnelsDisponibles(date,position);
        return ResponseEntity.status(HttpStatus.OK).body(personnels);
    }
    @PostMapping("/affecterPersonnels/{idPersonnel}/{idMatch}")
    public ResponseEntity<String> affecterPersonnel(@PathVariable int idPersonnel, @PathVariable int idMatch) throws DatatypeConfigurationException {
        if (organisateurService.affecterPersonnel(idPersonnel,idMatch))
            return ResponseEntity.status(HttpStatus.OK).body("Personnel affected");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Personnel not affected");
    }
    @PostMapping("/creerMatch")
    public ResponseEntity<String> creerMatch(@RequestBody Match match) {
        if (organisateurService.creerMatch(match))
            return ResponseEntity.status(HttpStatus.OK).body("match crée avec succes");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Verifier date");
    }
    @PostMapping("/modifierMatch")
    public ResponseEntity<String> modifierMatch(@RequestBody Match match) {
        String resultat = organisateurService.modifierMatch( match);
        return ResponseEntity.status(HttpStatus.OK).body(resultat);
    }
    @PostMapping("/supprimerMatch")
    public ResponseEntity<String> SupprimerMatch(@RequestBody int idMatch) {
        organisateurService.supprimerMatch(idMatch);
        return ResponseEntity.status(HttpStatus.OK).body("match supprimé avec succes");
    }

    @GetMapping("/consulterMatches")
    public ResponseEntity<List<Match>> afficherListeMatches() {
        List<Match> matches = organisateurService.loadMatches();
        return ResponseEntity.status(HttpStatus.OK).body(matches);
    }

}
