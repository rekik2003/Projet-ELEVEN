package com.mycompany.app.event_organization.controllers;
import com.mycompany.app.event_organization.entity.Organisateur;
import com.mycompany.app.event_organization.entity.Personnel;
import com.mycompany.app.event_organization.entity.Utilisateur;
import com.mycompany.app.event_organization.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/personnels/add")
    public ResponseEntity<Personnel> ajouterPersonnel(@RequestBody Personnel personnel) {
        Personnel nouvelPersonnel = adminService.creerPersonnel(personnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelPersonnel);
    }

    @PutMapping("/personnels/update")
    public ResponseEntity<Personnel> modifierPersonnel(@RequestBody Personnel personnel) {
        Personnel nouvelPersonnel = adminService.modifierPersonnel(personnel);
        return ResponseEntity.status(HttpStatus.OK).body(nouvelPersonnel);
    }

    @DeleteMapping("/personnels/delete")
    public ResponseEntity<Personnel>supprimerPersonnel(@RequestBody Personnel personnel) {
        adminService.supprimerPersonnel(personnel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/organisateurs/add")
    public ResponseEntity<Organisateur> ajouterOrganisateur(@RequestBody Organisateur organisateur) {
        Organisateur nouvelOrganisateur = adminService.creerOrganisateur(organisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelOrganisateur);
    }

    @PutMapping("/organisateurs/update")
    public ResponseEntity<Organisateur> modifierPersonnel(@RequestBody Organisateur organisateur) {
        adminService.modifierOrganisateur(organisateur);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/organisateurs/delete")
    public ResponseEntity<Organisateur>supprimerOrganisateur(@RequestBody Organisateur organisateur) {
        adminService.supprimerOrganisateur(organisateur);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}