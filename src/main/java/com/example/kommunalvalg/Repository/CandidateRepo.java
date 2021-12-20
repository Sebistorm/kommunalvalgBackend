package com.example.kommunalvalg.Repository;

import com.example.kommunalvalg.Model.Candidate;
import com.example.kommunalvalg.Model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

    List<Candidate> findAllByParty(Party party);

}
