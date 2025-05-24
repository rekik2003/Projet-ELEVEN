package com.mycompany.app.event_organization.wrappers;

import com.mycompany.app.event_organization.entity.Match;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Matches")
public class MatchesWrapper {
    private List<Match> matches;

    @XmlElement(name = "Match") // Maps XML <Match> elements to this list
    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
