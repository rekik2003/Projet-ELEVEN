package com.mycompany.app.event_organization.wrappers;

import com.mycompany.app.event_organization.entity.Affectation;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "Affectations")
public class AffectationsWrapper {
    private List<Affectation> affectations;

    @XmlElement(name = "Affectation") // Maps XML <Affectation> elements to this list
    public List<Affectation> getAffectations() {
        return affectations;
    }
    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }
}
