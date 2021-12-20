package com.example.kommunalvalg.Controller;

import com.example.kommunalvalg.Model.Candidate;
import com.example.kommunalvalg.Model.Party;
import com.example.kommunalvalg.Repository.CandidateRepo;
import com.example.kommunalvalg.Repository.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CandidateController {

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    PartyRepo partyRepo;

    @PostMapping(value="/createCandidate", consumes = "application/json")
    public ResponseEntity<Candidate> newCandidate(@RequestBody Candidate candidate) {
        System.out.println("Candidate:" + candidate);
        candidateRepo.save(candidate);
        System.out.println("Done save candidate =" + candidate);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.CREATED);
    }

    @PutMapping("/candidate/{candidateID}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable int candidateID, @RequestBody Candidate candidate) {
        Optional<Candidate> candidateData = candidateRepo.findById(candidateID);
        if(candidateData.isPresent()){
            Candidate _candidate = candidateData.get();
            _candidate.setCandidateName(candidate.getCandidateName());
            _candidate.setParty(candidate.getParty());
            _candidate = candidateRepo.save(_candidate);
            return new ResponseEntity<>(_candidate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/candidate/{candidateID}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable int candidateID) {
        try {
            candidateRepo.deleteById(candidateID);
        } catch (Exception error) {
            return new ResponseEntity<>("The Candidate was not found", HttpStatus.NOT_FOUND);
        }
          return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/candidates")
    public List<Candidate> allCandidates() {
        return candidateRepo.findAll();
    }

    @GetMapping("/candidates/{partyID}")
    public List<Candidate> allCandidatesFromParty(@PathVariable int partyID) {
        Optional<Party> partyData = partyRepo.findById(partyID);
        Party _party = partyData.get();
        return candidateRepo.findAllByParty(_party);

    }

    @GetMapping ("/candidate/{candidateID}")
    public Candidate getCandidateById(@PathVariable int candidateID){
        Optional<Candidate> obj = candidateRepo.findById(candidateID);
        if (obj.isPresent()) {
            return obj.get();
        }
        Candidate candidate = new Candidate();
        candidate.setCandidateName("Not Found");
        return candidate;
    }

}
