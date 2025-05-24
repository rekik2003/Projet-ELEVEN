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
 * <p>Classe Java pour Organisateur complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Organisateur">
 *   <complexContent>
 *     <extension base="{http://example.com/user}Utilisateur">
 *       <sequence>
 *         <element name="numTel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="match" type="{http://example.com/match}Match" maxOccurs="unbounded"/>
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
@XmlType(name = "Organisateur", propOrder = {
    "numTel",
    "match"
})
public class Organisateur
    extends Utilisateur {

    protected int numTel;
    @XmlElement(required = true)
    protected List<Match> match;

    /**
     * Obtient la valeur de la propriété numTel.
     */
    public int getNumTel() {
        return numTel;
    }

    /**
     * Définit la valeur de la propriété numTel.
     */
    public void setNumTel(int value) {
        this.numTel = value;
    }

    /**
     * Gets the value of the match property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the match property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getMatch().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Match }
     * </p>
     *
     * @return The value of the match property.
     */
    public List<Match> getMatch() {
        if (match == null) {
            match = new ArrayList<>();
        }
        return this.match;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if the objects are the same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Ensure the object is not null and is of the same class
        }
        Organisateur other = (Organisateur) obj;
        return id == other.id &&
                numTel == other.numTel &&
                Objects.equals(prenom, other.prenom) &&
                Objects.equals(nom, other.nom) &&
                Objects.equals(email, other.email) &&
                Objects.equals(login, other.login) &&
                Objects.equals(motDePasse, other.motDePasse) &&
                Objects.equals(role, other.role) &&
                Objects.equals(match, other.match);
    }
}
