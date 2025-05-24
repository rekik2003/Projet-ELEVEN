package com.mycompany.app.event_organization.services;

import com.mycompany.app.event_organization.entity.*;
import com.mycompany.app.event_organization.wrappers.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class OrganisateurService {

    // Chemins des fichiers XML pour stocker les données
    private static final String MATCH_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\matches.xml";
    private static final String RESERVATIONS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\reservations.xml";
    private static final String PERSONNELS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\personnels.xml";
    private static final String AFFECTATIONS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\affectations.xml";

    /**
     * Vérifie si un match peut être créé en contrôlant les conflits sur la date,
     * le lieu, et le titre.
     */
    public boolean valideMatch(Match match, List<Match> matches) {
        for (Match m : matches) {
            if (m.getDateMatch().equals(match.getDateMatch())) {
                if (m.getLieu().equals(match.getLieu()) || m.getTitre().equals(match.getTitre())) {
                    return false; // Conflit avec un match existant
                }
            }
        }
        return true; // Le match est valide
    }

    /**
     * Crée un nouveau match s'il est valide et le sauvegarde dans le fichier XML.
     */
    public boolean creerMatch(Match match) {
        List<Match> matches = loadMatches();
        if (matches.isEmpty()) {
            match.setIdMatch(123);
            matches.add(match);
            saveMatch(matches);
            return true;
        }

        // Vérifie la validité du match (date, lieu, titre)
        if (!valideMatch(match, matches)) {
            return false;
        }

        // Assigner un nouvel ID au match
        int lastId = matches.get(matches.size() - 1).getIdMatch();
        match.setIdMatch(lastId + 1);

        // Ajouter le match à la liste et sauvegarder
        matches.add(match);
        saveMatch(matches);
        return true;
    }

    /**
     * Modifie les informations d'un match existant.
     */
    public String modifierMatch(Match match) {
        List<Match> matches = loadMatches();
        List<Reservation> reservations = loadReservations();
        List<Reservation> reservationsDuMatch = new ArrayList<>();

        // Récupère les réservations associées au match
        for (Reservation reservation : reservations) {
            if (reservation.getMatch().equals(match)) {
                reservationsDuMatch.add(reservation);
            }
        }

        int nbReservation = reservationsDuMatch.size();

        // Mise à jour des informations du match
        for (Match m : matches) {
            if (m.getIdMatch() == match.getIdMatch()) {
                m.setCompetition(match.getCompetition());
                m.setDescription(match.getDescription());
                m.setDateMatch(match.getDateMatch());
                m.setLieu(match.getLieu());
                m.setTitre(match.getTitre());
                if (match.getNbMaxParticipants() < nbReservation) {
                    return "Match non modifié : Nombre maximum de participants insuffisant.";
                }
                m.setNbMaxParticipants(match.getNbMaxParticipants());
                break;
            }
        }
        saveMatch(matches);
        return "Match modifié avec succès.";
    }

    /**
     * Supprime un match en fonction de son ID.
     */
    public void supprimerMatch(int idMatch) {
        List<Match> matches = loadMatches();
        matches.removeIf(m -> m.getIdMatch() == idMatch); // Supprime le match correspondant
        saveMatch(matches);
    }

    /**
     * Affiche les personnels disponibles pour une date et une position données.
     */
    public List<Personnel> afficherPersonnelsDisponibles(XMLGregorianCalendar date, String position) throws DatatypeConfigurationException {
        List<Personnel> personnels = loadPersonnels();
        List<Personnel> personnelsDisponibles = new ArrayList<>();

        // Vérifie la disponibilité des personnels
        for (Personnel personnel : personnels) {
            if (personnel.getPosition().equals(position)) {
                for (XMLGregorianCalendar x : personnel.getAffectations()) {
                    if (!x.equals(date)) {
                        personnelsDisponibles.add(personnel);
                    }
                }
            }
        }
        return personnelsDisponibles;
    }

    /**
     * Affecte un personnel à un match et met à jour ses affectations.
     */
    public boolean affecterPersonnel(int idPersonnel, int idMatch) throws DatatypeConfigurationException {
        List<Personnel> personnels = loadPersonnels();
        List<Match> matches = loadMatches();
        List<Affectation> affectations = loadAffectations();

        Personnel personnelPourAffecter = null;
        Match matchPourAffectation = null;

        // Récupère le match correspondant
        for (Match match : matches) {
            if (match.getIdMatch() == idMatch) {
                matchPourAffectation = match;
                break;
            }
        }

        // Crée une nouvelle affectation
        LocalDateTime now = LocalDateTime.now();
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(now.atZone(ZoneId.systemDefault()));
        XMLGregorianCalendar dateAffectation = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

        // Récupère le personnel correspondant
        for (Personnel personnel : personnels) {
            if (personnel.getId() == idPersonnel) {
                personnelPourAffecter = personnel;

                // Met à jour la liste d'affectation
                personnelPourAffecter.getAffectations().add(matchPourAffectation.getDateMatch());
            }
        }

        // Sauvegarde les modifications
        savePersonnels(personnels);

        Affectation affectation = new Affectation();
        affectation.setMatch(matchPourAffectation);
        affectation.setDateAffectation(dateAffectation);
        affectation.setPersonnel(personnelPourAffecter);

        if (affectations == null) {
            affectations = new ArrayList<>();
        }
        affectations.add(affectation);
        saveAffectations(affectations);
        return true;
    }


    /**
     * Charge les personnels depuis le fichier XML.
     */
    private List<Personnel> loadPersonnels() {
        try {
            File file = new File(PERSONNELS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(PersonnelsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((PersonnelsWrapper) unmarshaller.unmarshal(file)).getPersonnels();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Charge les matches depuis le fichier XML.
     */
    public List<Match> loadMatches() {
        try {
            File file = new File(MATCH_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>(); // Retourne une liste vide si le fichier n'existe pas
            }
            JAXBContext context = JAXBContext.newInstance(MatchesWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((MatchesWrapper) unmarshaller.unmarshal(file)).getMatches();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Sauvegarde les matches dans le fichier XML.
     */
    private void saveMatch(List<Match> matches) {
        try {
            JAXBContext context = JAXBContext.newInstance(MatchesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            MatchesWrapper wrapper = new MatchesWrapper();
            wrapper.setMatches(matches);

            marshaller.marshal(wrapper, new File(MATCH_XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Charge les réservations depuis le fichier XML.
     */
    private List<Reservation> loadReservations() {
        try {
            File file = new File(RESERVATIONS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(ReservationWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((ReservationWrapper) unmarshaller.unmarshal(file)).getReservations();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Sauvegarde les réservations dans le fichier XML.
     */
    private void saveReservations(List<Reservation> reservations) {
        try {
            JAXBContext context = JAXBContext.newInstance(ReservationWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ReservationWrapper wrapper = new ReservationWrapper();
            wrapper.setReservations(reservations);

            marshaller.marshal(wrapper, new File(RESERVATIONS_XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Charge les affectations depuis le fichier XML.
     */
    private List<Affectation> loadAffectations() {
        try {
            File file = new File(AFFECTATIONS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(AffectationsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((AffectationsWrapper) unmarshaller.unmarshal(file)).getAffectations();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Sauvegarde les affectations dans le fichier XML.
     */
    private void saveAffectations(List<Affectation> affectations) {
        try {
            JAXBContext context = JAXBContext.newInstance(AffectationsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            AffectationsWrapper wrapper = new AffectationsWrapper();
            wrapper.setAffectations(affectations);

            marshaller.marshal(wrapper, new File(AFFECTATIONS_XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void savePersonnels(List<Personnel> personnels) {
        try {
            // Création du contexte JAXB pour la classe PersonnelsWrapper
            JAXBContext context = JAXBContext.newInstance(PersonnelsWrapper.class);

            // Création du marshaller pour convertir l'objet Java en XML
            Marshaller marshaller = context.createMarshaller();

            // Configuration pour que le fichier XML soit formaté (lisible)
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Création d'un wrapper pour encapsuler la liste des personnels
            PersonnelsWrapper wrapper = new PersonnelsWrapper();
            wrapper.setPersonnels(personnels);

            // Marshaller (conversion en XML) et sauvegarde dans le fichier spécifié
            marshaller.marshal(wrapper, new File(PERSONNELS_XML_FILE));
        } catch (JAXBException e) {
            // Gestion des exceptions liées au processus JAXB
            e.printStackTrace();
        }
    }
}
