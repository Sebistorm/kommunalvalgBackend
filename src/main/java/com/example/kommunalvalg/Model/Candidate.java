package com.example.kommunalvalg.Model;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateID;
    private String candidateName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partyID")
    private Party party;

    public Candidate() {
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", candidateName='" + candidateName + '\'' +
                ", party=" + party +
                '}';
    }
}
