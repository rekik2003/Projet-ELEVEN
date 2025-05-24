//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.mycompany.app.event_organization.entity;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.*;

import java.util.Objects;


/**
 * <p>Classe Java pour Match complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Match">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idMatch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="competition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="dateMatch" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="lieu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="nbMaxParticipants" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Match", namespace = "http://example.com/match", propOrder = {
    "idMatch",
    "competition",
    "dateMatch",
    "description",
    "lieu",
    "nbMaxParticipants",
    "titre"
})
public class Match {

    protected int idMatch;
    @XmlElement(required = true)
    protected String competition;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateMatch;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String lieu;
    protected int nbMaxParticipants;
    @XmlElement(required = true)
    protected String titre;

    /**
     * Obtient la valeur de la propriété idMatch.
     * 
     */
    public int getIdMatch() {
        return idMatch;
    }

    /**
     * Définit la valeur de la propriété idMatch.
     * 
     */
    public void setIdMatch(int value) {
        this.idMatch = value;
    }

    /**
     * Obtient la valeur de la propriété competition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * Définit la valeur de la propriété competition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetition(String value) {
        this.competition = value;
    }

    /**
     * Obtient la valeur de la propriété dateMatch.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateMatch() {
        return dateMatch;
    }

    /**
     * Définit la valeur de la propriété dateMatch.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateMatch(XMLGregorianCalendar value) {
        this.dateMatch = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété lieu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Définit la valeur de la propriété lieu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieu(String value) {
        this.lieu = value;
    }

    /**
     * Obtient la valeur de la propriété nbMaxParticipants.
     * 
     */
    public int getNbMaxParticipants() {
        return nbMaxParticipants;
    }

    /**
     * Définit la valeur de la propriété nbMaxParticipants.
     * 
     */
    public void setNbMaxParticipants(int value) {
        this.nbMaxParticipants = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if the objects are the same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Ensure the object is not null and is of the same class
        }
        Match other = (Match) obj;
        return idMatch == other.idMatch &&
                nbMaxParticipants == other.nbMaxParticipants &&
                Objects.equals(competition, other.competition) &&
                Objects.equals(dateMatch, other.dateMatch) &&
                Objects.equals(description, other.description) &&
                Objects.equals(lieu, other.lieu) &&
                Objects.equals(titre, other.titre);
    }

}
