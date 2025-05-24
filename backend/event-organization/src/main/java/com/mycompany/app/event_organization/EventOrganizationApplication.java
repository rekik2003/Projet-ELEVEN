package com.mycompany.app.event_organization;

import com.mycompany.app.event_organization.entity.*;
import com.mycompany.app.event_organization.wrappers.MatchesWrapper;
import com.mycompany.app.event_organization.wrappers.ParticipantsWrapper;
import com.mycompany.app.event_organization.wrappers.PersonnelsWrapper;
import com.mycompany.app.event_organization.wrappers.ReservationWrapper;
import jakarta.servlet.http.Part;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


@SpringBootApplication
public class EventOrganizationApplication {

    public static void main(String[] args) throws DatatypeConfigurationException {
        SpringApplication.run(EventOrganizationApplication.class, args);

//        LocalDateTime time=LocalDateTime.now();
//        GregorianCalendar gregorianCalendar = GregorianCalendar.from(time.atZone(ZoneId.systemDefault()));
//        DatatypeFactory datatypeFactory = null;
//        try {
//            datatypeFactory = DatatypeFactory.newInstance();
//        } catch (DatatypeConfigurationException e) {
//            throw new RuntimeException(e);
//        }
//        XMLGregorianCalendar xmlGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
//
//        Match object = new Match();
//        object.setIdMatch(3);
//        object.setCompetition("competitive");
//        object.setDescription("PSG vs Barca");
//        object.setTitre("messiiii");
//        object.setDateMatch(xmlGregorianCalendar);
//        object.setNbMaxParticipants(1000);
//        List<Match> matches = new ArrayList<>();
//        matches.add(object);
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(MatchesWrapper.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            MatchesWrapper wrapper = new MatchesWrapper();
//            wrapper.setMatches(matches);
//            marshaller.marshal(wrapper, new File("C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\matches.xml"));
//            System.out.println("matches XML file created successfully.");
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

//        Participant object = new Participant();
//        object.setId(100001);
//        object.setAdresse("sdjfnslkds");
//        object.setNumTel(45545578);
//        object.setEmail("suiiiiisdi@gmds.com");
//        object.setLogin("lksdjflsdfs");
//        object.setMotDePasse("lskdjflsd");
//        object.setNom("mo7sen");
//        object.setPrenom("tchedo to7sel");
//        object.setRole("participant");
//        List<Participant> participants = new ArrayList<>();
//        boolean add = participants.add(object);
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(ParticipantsWrapper.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            ParticipantsWrapper wrapper = new ParticipantsWrapper();
//            wrapper.setParticipants(participants);
//
//            marshaller.marshal(wrapper, new File("C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\participants.xml"));
//            System.out.println("Personnel XML file created successfully.");
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }
}