//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.mycompany.app.event_organization.entity;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour Affectation complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Affectation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dateAffectation" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="match" type="{http://example.com/match}Match"/>
 *         <element name="personnel" type="{http://example.com/personnel}Personnel"/>
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
@XmlType(name = "Affectation", propOrder = {
    "dateAffectation",
    "match",
    "personnel"
})
public class Affectation {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateAffectation;
    @XmlElement(required = true)
    protected Match match;
    @XmlElement(required = true)
    protected Personnel personnel;

    /**
     * Obtient la valeur de la propriété dateAffectation.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAffectation() {
        return dateAffectation;
    }

    /**
     * Définit la valeur de la propriété dateAffectation.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAffectation(XMLGregorianCalendar value) {
        this.dateAffectation = value;
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
     * Obtient la valeur de la propriété personnel.
     * 
     * @return
     *     possible object is
     *     {@link Personnel }
     *     
     */
    public Personnel getPersonnel() {
        return personnel;
    }

    /**
     * Définit la valeur de la propriété personnel.
     * 
     * @param value
     *     allowed object is
     *     {@link Personnel }
     *     
     */
    public void setPersonnel(Personnel value) {
        this.personnel = value;
    }

}
