//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.mycompany.app.event_organization.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour Participant complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Participant">
 *   <complexContent>
 *     <extension base="{http://example.com/user}Utilisateur">
 *       <sequence>
 *         <element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="numTel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="preferences" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
@XmlType(name = "Participant", namespace = "http://example.com/participant", propOrder = {
    "adresse",
    "numTel",
    "preferences"
})
public class Participant
    extends Utilisateur
{

    @XmlElement(required = true)
    protected String adresse;
    protected int numTel;
    @XmlElement(required = true)
    protected List<String> preferences;

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propriété numTel.
     * 
     */
    public int getNumTel() {
        return numTel;
    }

    /**
     * Définit la valeur de la propriété numTel.
     * 
     */
    public void setNumTel(int value) {
        this.numTel = value;
    }

    /**
     * Gets the value of the preferences property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preferences property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getPreferences().add(newItem);
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
     *     The value of the preferences property.
     */
    public List<String> getPreferences() {
        if (preferences == null) {
            preferences = new ArrayList<>();
        }
        return this.preferences;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if the objects are the same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Ensure the object is not null and is of the same class
        }
        Participant other = (Participant) obj;
        return id == other.id &&
                Objects.equals(prenom, other.prenom) &&
                Objects.equals(nom, other.nom) &&
                Objects.equals(email, other.email) &&
                Objects.equals(login, other.login) &&
                Objects.equals(motDePasse, other.motDePasse) &&
                Objects.equals(role, other.role) &&
                Objects.equals(adresse, other.adresse) &&
                Objects.equals(numTel, other.numTel) &&
                Objects.equals(preferences, other.preferences);
    }

}
