package com.example.kommunalvalg.Controller;

import com.example.kommunalvalg.Model.Party;
import com.example.kommunalvalg.Repository.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PartyController {
    @Autowired
    PartyRepo partyRepo;

    @GetMapping("/parties")
    public List<Party> allParties() {
        return partyRepo.findAll();
    }
}
