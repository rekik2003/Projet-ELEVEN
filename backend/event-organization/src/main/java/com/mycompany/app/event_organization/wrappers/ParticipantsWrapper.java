package com.mycompany.app.event_organization.wrappers;

import com.mycompany.app.event_organization.entity.Participant;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "participants")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantsWrapper {

    @XmlElement(name = "participant")
    private List<Participant> participants;

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
