package com.example.kommunalvalg.Repository;

import com.example.kommunalvalg.Model.Candidate;
import com.example.kommunalvalg.Model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

    List<Candidate> findAllByParty(Party party);

    @Query(value = "SELECT SUM(number_of_votes) FROM candidate", nativeQuery = true)
    int getVotesTotal();

    @Query(value = "SELECT partyid, SUM(number_of_votes) FROM candidate GROUP BY partyid;", nativeQuery = true)
    List<Object[]> getPartyVotes();

    @Query(value = "select * from candidate order by number_of_votes desc limit 5;", nativeQuery = true)
    List<Candidate> getTopFiveCandidates();


}
