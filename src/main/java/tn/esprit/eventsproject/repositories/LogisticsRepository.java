package tn.esprit.eventsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.eventsproject.entities.Logistics;

import java.util.List;
@Repository

public interface LogisticsRepository extends JpaRepository<Logistics, Integer> {


}