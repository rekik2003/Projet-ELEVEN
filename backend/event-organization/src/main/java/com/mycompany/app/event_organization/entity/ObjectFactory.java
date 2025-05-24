//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.mycompany.app.event_organization.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.app.event_organization.entity package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Match_QNAME = new QName("http://example.com/match", "match");
    private static final QName _Utilisateur_QNAME = new QName("http://example.com/user", "Utilisateur");
    private static final QName _Affectation_QNAME = new QName("http://example.com/affectation", "affectation");
    private static final QName _PersonnelEvenementiel_QNAME = new QName("http://example.com/personnel", "personnelEvenementiel");
    private static final QName _Reservation_QNAME = new QName("http://example.com/reservation", "reservation");
    private static final QName _Organisateur_QNAME = new QName("http://example.com/organizer", "organisateur");
    private static final QName _Admin_QNAME = new QName("http://example.com/admin", "admin");
    private static final QName _Participant_QNAME = new QName("http://example.com/participant", "participant");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.app.event_organization.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Admin }
     * 
     * @return
     *     the new instance of {@link Admin }
     */
    public Admin createAdmin() {
        return new Admin();
    }

    /**
     * Create an instance of {@link Affectation }
     * 
     * @return
     *     the new instance of {@link Affectation }
     */
    public Affectation createAffectation() {
        return new Affectation();
    }
    
    /**
     * Create an instance of {@link Reservation }
     * 
     * @return
     *     the new instance of {@link Reservation }
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Personnel }
     * 
     * @return
     *     the new instance of {@link Personnel }
     */
    public Personnel createPersonnel() {
        return new Personnel();
    }

    /**
     * Create an instance of {@link Participant }
     * 
     * @return
     *     the new instance of {@link Participant }
     */
    public Participant createParticipant() {
        return new Participant();
    }

    /**
     * Create an instance of {@link Organisateur }
     * 
     * @return
     *     the new instance of {@link Organisateur }
     */
    public Organisateur createOrganisateur() {
        return new Organisateur();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     * @return
     *     the new instance of {@link Utilisateur }
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Match }
     * 
     * @return
     *     the new instance of {@link Match }
     */
    public Match createMatch() {
        return new Match();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Affectation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Affectation }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/affectation", name = "affectation")
    public JAXBElement<Affectation> createAffectation(Affectation value) {
        return new JAXBElement<>(_Affectation_QNAME, Affectation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Personnel }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Personnel }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/personnel", name = "personnelEvenementiel")
    public JAXBElement<Personnel> createPersonnelEvenementiel(Personnel value) {
        return new JAXBElement<>(_PersonnelEvenementiel_QNAME, Personnel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Utilisateur }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Utilisateur }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/user", name = "Utilisateur")
    public JAXBElement<Utilisateur> createUtilisateur(Utilisateur value) {
        return new JAXBElement<>(_Utilisateur_QNAME, Utilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Match }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Match }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/match", name = "match")
    public JAXBElement<Match> createMatch(Match value) {
        return new JAXBElement<>(_Match_QNAME, Match.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/reservation", name = "reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<>(_Reservation_QNAME, Reservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Admin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Admin }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/admin", name = "admin")
    public JAXBElement<Admin> createAdmin(Admin value) {
        return new JAXBElement<>(_Admin_QNAME, Admin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Participant }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Participant }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/participant", name = "participant")
    public JAXBElement<Participant> createParticipant(Participant value) {
        return new JAXBElement<>(_Participant_QNAME, Participant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organisateur }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Organisateur }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/organizer", name = "organisateur")
    public JAXBElement<Organisateur> createOrganisateur(Organisateur value) {
        return new JAXBElement<>(_Organisateur_QNAME, Organisateur.class, null, value);
    }

}
