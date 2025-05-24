package com.mycompany.app.event_organization.controllers;
import com.mycompany.app.event_organization.entity.Match;
import com.mycompany.app.event_organization.entity.Participant;
import com.mycompany.app.event_organization.entity.Reservation;
import com.mycompany.app.event_organization.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/participant")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;
    @PostMapping("/{participantId}/reservationTicket/{matchId}")
    public ResponseEntity<Reservation> reserverTicket(@PathVariable("matchId") int matchId, @PathVariable("participantId") int participantId) throws DatatypeConfigurationException {
        try {
            Reservation reservation=participantService.reserverTicket(matchId,participantId);
            if (reservation == null)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{participantId}/reservations/delete")
    public ResponseEntity<String> annulerReservation(@RequestBody Reservation reservation) {
        try {
            if (participantService.annulerReservation(reservation))
                return ResponseEntity.ok("Reservation cancelled successfully");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update profile");
        }
    }

    @GetMapping("/{participantId}/reservations")
    public ResponseEntity<List<Reservation>> getReservationsForParticipant(@PathVariable int participantId) {
        try {
            List<Reservation> reservations = participantService.listeTicketsReserves(participantId);
            if (reservations.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 No Content if no reservations are found
            }
            return ResponseEntity.ok(reservations); // Return 200 OK with the list of reservations
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 Internal Server Error for unexpected issues
        }
    }

    @PutMapping("/{participantId}/updateProfile")
    public ResponseEntity<String> updateProfile(@RequestBody Participant participant) {
        try {
            participantService.updateParticipant(participant);
            return ResponseEntity.ok("Participant profile updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update profile");
        }
    }

    @GetMapping("/consulterMatches")
    public ResponseEntity<List<Match>> afficherListeMatches() {
        List<Match> matches = participantService.loadMatches();
        return ResponseEntity.status(HttpStatus.OK).body(matches);
    }
}