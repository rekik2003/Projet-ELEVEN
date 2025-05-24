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
 * <p>Classe Java pour Reservation complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Reservation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="block" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="dateReservation" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="numPlace" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="match" type="{http://example.com/match}Match"/>
 *         <element name="participant" type="{http://example.com/participant}Participant"/>
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
@XmlType(name = "Reservation", propOrder = {
    "block",
    "dateReservation",
    "numPlace",
    "match",
    "participant"
})
public class Reservation {

    @XmlElement(required = true)
    protected String block;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateReservation;
    protected int numPlace;
    @XmlElement(required = true)
    protected Match match;
    @XmlElement(required = true)
    protected Participant participant;

    /**
     * Obtient la valeur de la propriété block.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlock() {
        return block;
    }

    /**
     * Définit la valeur de la propriété block.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlock(String value) {
        this.block = value;
    }

    /**
     * Obtient la valeur de la propriété dateReservation.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateReservation() {
        return dateReservation;
    }

    /**
     * Définit la valeur de la propriété dateReservation.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateReservation(XMLGregorianCalendar value) {
        this.dateReservation = value;
    }

    /**
     * Obtient la valeur de la propriété numPlace.
     * 
     */
    public int getNumPlace() {
        return numPlace;
    }

    /**
     * Définit la valeur de la propriété numPlace.
     * 
     */
    public void setNumPlace(int value) {
        this.numPlace = value;
    }

    /**
     * Obtient la valeur de la propriété match.
     * 
     * @return
     *     possible object is
     *     {@link Match }
     *     
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Définit la valeur de la propriété match.
     * 
     * @param value
     *     allowed object is
     *     {@link Match }
     *     
     */
    public void setMatch(Match value) {
        this.match = value;
    }

    /**
     * Obtient la valeur de la propriété participant.
     * 
     * @return
     *     possible object is
     *     {@link Participant }
     *     
     */
    public Participant getParticipant() {
        return participant;
    }

    /**
     * Définit la valeur de la propriété participant.
     * 
     * @param value
     *     allowed object is
     *     {@link Participant }
     *     
     */
    public void setParticipant(Participant value) {
        this.participant = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if the objects are the same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Ensure the object is not null and is of the same class
        }
        Reservation other = (Reservation) obj;
        return Objects.equals(block, other.block) &&
                Objects.equals(dateReservation, other.dateReservation) &&
                Objects.equals(numPlace, other.numPlace) &&
                match.equals(other.match) &&
                participant.equals(other.participant);
    }


}
