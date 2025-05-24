package com.mycompany.app.event_organization.wrappers;

import com.mycompany.app.event_organization.entity.Organisateur;
import com.mycompany.app.event_organization.entity.Personnel;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Organisateurs")
public class OrganisateursWrapper {

    private List<Organisateur> organisateurs;

    @XmlElement(name = "Organisateur")
    public List<Organisateur> getOrganisateurs() {
        return organisateurs;
    }

    public void setOrganisateurs(List<Organisateur> organisateurs) {
        this.organisateurs = organisateurs;
    }
}