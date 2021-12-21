package com.example.kommunalvalg;

import com.example.kommunalvalg.Model.Candidate;
import com.example.kommunalvalg.Model.Party;
import com.example.kommunalvalg.Repository.CandidateRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;

class CandidateRepoTests {

    @Autowired
    CandidateRepo candidateRepo;

    @Test
    void test_calcCandidatesParty(){
        Party party = new Party(1, "Venstre", "V", null);
        Candidate candidate = new Candidate(1, "Ove Pedersen", 250, party);
        candidate.getParty().getPartyName();
        assertEquals("Venstre", candidate.getParty().getPartyName());
    }


}
