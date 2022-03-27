package com.example.kommunalvalg.Model;


import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateID;
    private String candidateName;
    private int numberOfVotes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partyID")
    private Party party;

    public Candidate() {
    }

    public Candidate(int candidateID, String candidateName, int numberOfVotes, Party party) {
        this.candidateID = candidateID;
        this.candidateName = candidateName;
        this.numberOfVotes = numberOfVotes;
        this.party = party;
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

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", candidateName='" + candidateName + '\'' +
                ", numberOfVotes=" + numberOfVotes +
                ", party=" + party +
                '}';
    }
}
