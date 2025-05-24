package com.mycompany.app.event_organization.services;

import com.mycompany.app.event_organization.entity.Affectation;
import com.mycompany.app.event_organization.entity.Personnel;
import com.mycompany.app.event_organization.wrappers.AffectationsWrapper;
import com.mycompany.app.event_organization.wrappers.PersonnelsWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonnelService {

    private static final String PERSONNELS_XML_FILE = "D:\\Downloads\\projetXML-main (6)\\projetXML-main\\event-organization\\src\\main\\resources\\xml docs\\personnels.xml";
    private static final String AFFECTATIONS_XML_FILE = "D:\\Downloads\\projetXML-main (6)\\projetXML-main\\event-organization\\src\\main\\resources\\xml docs\\affectations.xml";

    public List<Affectation> afficherAffectations(int idPersonnel) {
        List<Affectation> affectations = loadAffectations();
        List<Affectation> affectationsPourUnPersonnels = new ArrayList<>();
        for (Affectation affectation : affectations) {
            if(affectation.getPersonnel().getId()==idPersonnel){
                affectationsPourUnPersonnels.add(affectation);
            }
        }
        return affectationsPourUnPersonnels;
    }

    private List<Affectation> loadAffectations() {
        try {
            File file = new File(AFFECTATIONS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(AffectationsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AffectationsWrapper wrapper = (AffectationsWrapper) unmarshaller.unmarshal(file);

            return wrapper.getAffectations();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    private List<Personnel> loadPersonnels() {
        try {
            File file = new File(PERSONNELS_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            JAXBContext context = JAXBContext.newInstance(PersonnelsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PersonnelsWrapper wrapper = (PersonnelsWrapper) unmarshaller.unmarshal(file);
            return wrapper.getPersonnels();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void savePersonnels(List<Personnel> personnels) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonnelsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            PersonnelsWrapper wrapper = new PersonnelsWrapper();
            wrapper.setPersonnels(personnels);
            marshaller.marshal(wrapper, new File(PERSONNELS_XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
