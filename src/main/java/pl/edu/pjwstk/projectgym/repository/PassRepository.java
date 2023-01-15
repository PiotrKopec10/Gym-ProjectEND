package pl.edu.pjwstk.projectgym.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projectgym.model.Clients;
import pl.edu.pjwstk.projectgym.model.Pass;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassRepository extends JpaRepository<Pass,Long> {
    Optional<Pass> findPassByCategory(Pass pass);
}
