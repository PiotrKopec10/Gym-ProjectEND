package pl.edu.pjwstk.projectgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projectgym.model.Events;

import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {
    Optional<Events>findEventsByNameOfEvent(String nameOfEvent);

}
