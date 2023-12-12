package tn.esprit.eventsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Tache;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findByDescription(String description);
    List<Event> findByDateDebutBetween(LocalDate date1, LocalDate date2);

    List<Event> findByParticipants_NomAndParticipants_PrenomAndParticipants_Tache(String nom, String prenom, Tache tache);



}