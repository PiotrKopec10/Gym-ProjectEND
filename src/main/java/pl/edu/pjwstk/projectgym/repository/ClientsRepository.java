package pl.edu.pjwstk.projectgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projectgym.model.Clients;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,Long> {

    Optional<Clients> findClientsByNameAndSurname(String name, String surname);
//    Clients findClientsByFirstName(String name);
}
