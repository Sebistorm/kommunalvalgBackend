package com.example.kommunalvalg.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyID;
    private String partyName;
    private String partySymbol;

    @OneToMany
    @JoinColumn(name = "partyID")
    @JsonBackReference
    private Set<Candidate> candidate = new HashSet<>();

    public Party() {
    }

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Set<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(Set<Candidate> candidate) {
        this.candidate = candidate;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public void setPartySymbol(String partySymbol) {
        this.partySymbol = partySymbol;
    }

    @Override
    public String toString() {
        return "Party{" +
                "partyID=" + partyID +
                ", partyName='" + partyName + '\'' +
                ", partySymbol='" + partySymbol + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
