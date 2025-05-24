//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.mycompany.app.event_organization.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Personnel complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Personnel">
 *   <complexContent>
 *     <extension base="{http://example.com/user}Utilisateur">
 *       <sequence>
 *         <element name="competences" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         <element name="position" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="affectations" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Personnel", namespace = "http://example.com/personnel", propOrder = {
    "competences",
    "position",
    "affectations"
})
public class Personnel
    extends Utilisateur
{

    @XmlElement(required = true)
    protected List<String> competences;
    @XmlElement(required = true)
    protected String position;
    @XmlElement(required = true)
    protected List<XMLGregorianCalendar> affectations;

    /**
     * Gets the value of the competences property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the competences property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCompetences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * </p>
     * 
     * 
     * @return
     *     The value of the competences property.
     */
    public List<String> getCompetences() {
        if (competences == null) {
            competences = new ArrayList<>();
        }
        return this.competences;
    }

    /**
     * Obtient la valeur de la propriété position.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the affectations property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the affectations property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAffectations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLGregorianCalendar }
     * </p>
     *
     *
     * @return
     *     The value of the affectations property.
     */
    public List<XMLGregorianCalendar> getAffectations() {
        if (affectations == null) {
            affectations = new ArrayList<>();
        }
        return this.affectations;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if the objects are the same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Ensure the object is not null and is of the same class
        }
        Personnel other = (Personnel) obj;
        return id == other.id &&
                Objects.equals(prenom, other.prenom) &&
                Objects.equals(nom, other.nom) &&
                Objects.equals(email, other.email) &&
                Objects.equals(login, other.login) &&
                Objects.equals(motDePasse, other.motDePasse) &&
                Objects.equals(role, other.role) &&
                Objects.equals(position, other.position) &&
                Objects.equals(affectations, other.affectations) &&
                Objects.equals(competences, other.competences);
    }

}
