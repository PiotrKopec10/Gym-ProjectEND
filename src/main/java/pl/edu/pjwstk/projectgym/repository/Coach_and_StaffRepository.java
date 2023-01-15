package pl.edu.pjwstk.projectgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projectgym.model.Coach_and_Staff;

import java.util.Optional;

@Repository
public interface Coach_and_StaffRepository extends JpaRepository<Coach_and_Staff,Long> {
    Optional<Coach_and_Staff> findCoach_and_StaffByNameAndSurname(String name, String surname);
//    Coach_and_Staff findCoach_and_StaffByFirstName(String name);
}
