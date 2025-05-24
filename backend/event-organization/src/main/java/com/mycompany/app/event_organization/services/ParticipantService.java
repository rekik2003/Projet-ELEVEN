package com.mycompany.app.event_organization.services;

import com.mycompany.app.event_organization.entity.Match;
import com.mycompany.app.event_organization.entity.Participant;
import com.mycompany.app.event_organization.entity.Reservation;
import com.mycompany.app.event_organization.wrappers.ParticipantsWrapper;
import com.mycompany.app.event_organization.wrappers.ReservationWrapper;
import com.mycompany.app.event_organization.wrappers.MatchesWrapper;
import jakarta.servlet.http.Part;
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
public class ParticipantService {
    private static final String PARTICIPANTS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\participants.xml";
    private static final String RESERVATIONS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\reservations.xml";
    private static final String MATCHES_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\matches.xml";

    public Match getMatchById(int id) {
        try {
            // Unmarshal XML
            File file = new File(MATCHES_XML_FILE);
            JAXBContext context = JAXBContext.newInstance(MatchesWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            MatchesWrapper wrapper = (MatchesWrapper) unmarshaller.unmarshal(file);

            // Find match by ID
            Optional<Match> match = wrapper.getMatches()
                    .stream()
                    .filter(m -> m.getIdMatch() == id)
                    .findFirst();

            return match.orElse(null); // Return the match or null if not found
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Participant getParticipantById(int id) {
        try {
            // Unmarshal XML
            File file = new File(PARTICIPANTS_XML_FILE);
            JAXBContext context = JAXBContext.newInstance(ParticipantsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ParticipantsWrapper wrapper = (ParticipantsWrapper) unmarshaller.unmarshal(file);

            // Find match by ID
            Optional<Participant> participant = wrapper.getParticipants()
                    .stream()
                    .filter(p -> p.getId() == id)
                    .findFirst();

            return participant.orElse(null); // Return the participant or null if not found
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Reservation reserverTicket(int matchId , int participantId) throws DatatypeConfigurationException {
        Match match = getMatchById(matchId);
        Participant participant = getParticipantById(participantId);
        if (match == null || participant == null)
            return null;

        Random rand = new Random();
        List<String> listOfBlocks = new ArrayList<>(Arrays.asList("A1", "B2", "C3", "D4", "E5", "F6", "G7", "H8", "I9"));
        List<Reservation> reservations = loadReservations();

        List<Reservation> reservationsDuMatch = new ArrayList<>();
        Reservation reservationAEnregistrer = new Reservation();

        String block = listOfBlocks.get(rand.nextInt(listOfBlocks.size()));
        int numPlace = rand.nextInt(match.getNbMaxParticipants());

        reservationAEnregistrer.setBlock(block);
        reservationAEnregistrer.setMatch(match);
        reservationAEnregistrer.setParticipant(participant);
        reservationAEnregistrer.setNumPlace(numPlace);

        LocalDateTime time = LocalDateTime.now();
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(time.atZone(ZoneId.systemDefault()));
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar xmlGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);

        reservationAEnregistrer.setDateReservation(xmlGregorianCalendar);

        if (reservations == null) {
            reservations = new ArrayList<>();
            reservations.add(reservationAEnregistrer);
            saveReservations(reservations);
            return reservationAEnregistrer;
        }
        reservations.add(reservationAEnregistrer);

        saveReservations(reservations);

//        for (Reservation reservation : reservations) {
//            if (reservation.getMatch().equals(match)) {
//                reservationsDuMatch.add(reservation);
//            }
//        }
//        boolean placefound = true;
//        while (placefound) {
//            for (Reservation reservation : reservationsDuMatch) {
//                if (reservation.getBlock() != block || reservation.getNumPlace() != numPlace) {
//                    placefound = false;
//                    reservations.add(reservationAEnregistrer);
//                    saveReservations(reservations);
//                } else {
//                    block = listOfBlocks.get(rand.nextInt(listOfBlocks.size()));
//                    numPlace = rand.nextInt(5000);
//                    reservationAEnregistrer.setNumPlace(numPlace);
//                    reservationAEnregistrer.setBlock(block);
//                }
//            }
//        }
        return reservationAEnregistrer;
    }

    public List<Reservation> listeTicketsReserves(int  participantId) {
        List<Reservation> ticketsReserves = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        try {
            reservations = loadReservations();
            for (Reservation reservation : reservations) {
                if (reservation.getParticipant().getId() == participantId) {
                    ticketsReserves.add(reservation);
                }
            }
        } catch (Exception e) {
            System.err.println("No reservations: ");
        }
        return ticketsReserves;
    }

    public void updateParticipant(Participant participant) {
        try {
            List<Participant> participants = loadParticipants();
            participants = removeParticipantById(participant.getId(), participants);
            participants.add(participant);
            saveParticipants(participants);
        } catch (Exception e) {
            System.err.println("Error loading participants");
        }
    }

    public List<Participant> removeParticipantById(int participantId, List<Participant>participants) {
        for (Participant participant : participants) {
            if (participant.getId() == participantId) {
                participants.remove(participant);
                break;
            }
        }
        return participants;
    }

    public List<Participant> loadParticipants() {
        try {
            File file = new File(PARTICIPANTS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(ParticipantsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ParticipantsWrapper wrapper = (ParticipantsWrapper) unmarshaller.unmarshal(file);
            return wrapper.getParticipants();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveParticipants(List<Participant> participants) {
        try {
            JAXBContext context = JAXBContext.newInstance(ParticipantsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ParticipantsWrapper wrapper = new ParticipantsWrapper();
            wrapper.setParticipants(participants);
            marshaller.marshal(wrapper, new File(PARTICIPANTS_XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private List<Reservation> loadReservations() {
        try {
            File file = new File(RESERVATIONS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(ReservationWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ReservationWrapper wrapper = (ReservationWrapper) unmarshaller.unmarshal(file);
            return wrapper.getReservations();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

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

    public boolean annulerReservation(Reservation reservationASupprimer) {
        boolean result = false ;
        List<Reservation> reservations = loadReservations();
        for (Reservation reservation : reservations) {
            if (reservation.equals(reservationASupprimer)) {
                result = reservations.remove(reservation);
                break;
            }
        }
        saveReservations(reservations);
        return result;
    }

    public List<Match> loadMatches() {
        try {
            File file = new File(MATCHES_XML_FILE);
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

}
