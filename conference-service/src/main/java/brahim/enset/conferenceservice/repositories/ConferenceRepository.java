package brahim.enset.conferenceservice.repositories;


import brahim.enset.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    // La méthode findByType doit correspondre à une propriété 'type' dans l'entité Conference
    List<Conference> findByType(String type);
}

