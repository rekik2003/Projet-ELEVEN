package com.mycompany.app.event_organization.wrappers;
import com.mycompany.app.event_organization.entity.Reservation;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "Reservations")
public class ReservationWrapper {
    private List<Reservation> reservations;
    @XmlElement(name = "reservation")
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}