package com.mycompany.app.event_organization.wrappers;
import com.mycompany.app.event_organization.entity.Personnel;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Personnels")
public class PersonnelsWrapper {
    private List<Personnel> personnels;
    @XmlElement(name = "Personnel")
    public List<Personnel> getPersonnels() {
        return personnels;
    }
    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }
}