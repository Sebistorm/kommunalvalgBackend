package com.example.kommunalvalg.Repository;

import com.example.kommunalvalg.Model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<Party, Integer> {
}
