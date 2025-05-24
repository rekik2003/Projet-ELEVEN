package com.mycompany.app.event_organization.services;

import com.mycompany.app.event_organization.entity.Organisateur;
import com.mycompany.app.event_organization.entity.Participant;
import com.mycompany.app.event_organization.entity.Personnel;
import com.mycompany.app.event_organization.entity.Reservation;
import com.mycompany.app.event_organization.wrappers.OrganisateursWrapper;
import com.mycompany.app.event_organization.wrappers.PersonnelsWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {
    private static final String PERSONNELS_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\personnels.xml";
    private static final String PARTICIPANT_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\particpants.xml";
    private static final String ORGANISATEUR_XML_FILE = "C:\\Users\\rekik\\IdeaProjects\\projetXML\\event-organization\\src\\main\\resources\\xml docs\\organisateurs.xml";
    boolean validLogin;

    public boolean checkEmail(String email) {
        // A simple regex pattern to validate the email format
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email != null && email.matches(emailPattern);
    }

    // Method to check if the login and password match
    public boolean checkLoginAndMotDePasse(String login1, String motDePasse1, String login2, String motDePasse2) {
        if (login2.equals(login1)) {
            // Check if the provided password matches the stored password
            return motDePasse2.equals(motDePasse1);
        }
        return false;
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

    private List<Personnel> removePersonnelById(int personnelId, List<Personnel> personnels){
        for (Personnel p : personnels) {
            if (p.getId() == personnelId) {
                personnels.remove(p);
                break;
            }
        }
        return personnels;
    }

    private List<Organisateur> removeOrganisateurById(int organisateurId, List<Organisateur> organisateurs){
        for (Organisateur o : organisateurs) {
            if (o.getId() == organisateurId) {
                organisateurs.remove(o);
                break;
            }
        }
        return organisateurs;
    }

    private List<Organisateur> loadOrganisateurs() {
        try {
            File file = new File(ORGANISATEUR_XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }

            JAXBContext context = JAXBContext.newInstance(OrganisateursWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            OrganisateursWrapper wrapper = (OrganisateursWrapper) unmarshaller.unmarshal(file);

            return wrapper.getOrganisateurs();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveOrganisateurs(List<Organisateur> organisateurs) {
        try {
            JAXBContext context = JAXBContext.newInstance(OrganisateursWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            OrganisateursWrapper wrapper = new OrganisateursWrapper();
            wrapper.setOrganisateurs(organisateurs);
            marshaller.marshal(wrapper, new File(ORGANISATEUR_XML_FILE));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Personnel creerPersonnel(Personnel personnel) {
        // Load existing users from the XML file
        List<Personnel> personnels = loadPersonnels();

        //Validate Email not null , not duplicated and matches pattern
        if (!checkEmail(personnel.getEmail()))
            throw new IllegalArgumentException("Re-enter a valid Email");

        //Validate login and password uniqueness
        for (Personnel personnel2 : personnels) {
            if (checkLoginAndMotDePasse(personnel.getLogin(), personnel.getMotDePasse(), personnel2.getLogin(), personnel2.getMotDePasse()))
                throw new IllegalArgumentException("Change Login or Password");
        }

        personnel.setRole("personnel");

        //use the last id to increment id value
        personnel.setId(personnels.get(personnels.size() - 1).getId() + 1);

        // Add the new user
        personnels.add(personnel);

        // Save the updated list back to the XML file
        savePersonnels(personnels);
        return personnel;
    }

    public Personnel modifierPersonnel(Personnel personnel){
        try {
            List<Personnel> personnels = loadPersonnels();
            personnels = removePersonnelById(personnel.getId(), personnels);
            personnels.add(personnel);
            savePersonnels(personnels);
        } catch (Exception e) {
            System.err.println("Error loading personnels");
        }
        return personnel;
    }

    public void supprimerPersonnel(Personnel personnel){
        List<Personnel> personnels = loadPersonnels();
        for (Personnel p : personnels) {
            if (personnel.equals(p)) {
                personnels.remove(personnel);
                break;
            }
        }
        savePersonnels(personnels);
    }

    public Organisateur creerOrganisateur(Organisateur organisateur) {
        // Load existing organisateurs from the XML file
        List<Organisateur> organisateurs = loadOrganisateurs();

        //Validate Email not null , not duplicated and matches pattern
        if (!checkEmail(organisateur.getEmail()))
            throw new IllegalArgumentException("Re-enter a valid Email");

        //Validate login
        for (Organisateur organisateur2 : organisateurs) {
            if (checkLoginAndMotDePasse(organisateur.getLogin(), organisateur.getMotDePasse(), organisateur2.getLogin(), organisateur2.getMotDePasse()))
                throw new IllegalArgumentException("Change Login or Password");
        }

        //use the last id to increment id value and set the role
        if (organisateurs.isEmpty())
            organisateur.setId(1);
        else
            organisateur.setId(organisateurs.get(organisateurs.size() - 1).getId() + 1);
        organisateur.setRole("organisateur");

        // Add the new user
        organisateurs.add(organisateur);

        // Save the updated list back to the XML file
        saveOrganisateurs(organisateurs);
        return organisateur;
    }

    public Organisateur modifierOrganisateur(Organisateur organisateur){
        try {
            List<Organisateur> organisateurs = loadOrganisateurs();
            organisateurs = removeOrganisateurById(organisateur.getId(), organisateurs);
            organisateurs.add(organisateur);
            saveOrganisateurs(organisateurs);
        } catch (Exception e) {
            System.err.println("Error loading organisateurs");
        }
        return organisateur;
    }

    public void supprimerOrganisateur(Organisateur organisateur){
        List<Organisateur> organisateurs = loadOrganisateurs();
        for (Organisateur o : organisateurs) {
            if (organisateur.equals(o)) {
                organisateurs.remove(organisateur);
                break;
            }
        }
        saveOrganisateurs(organisateurs);
    }

}