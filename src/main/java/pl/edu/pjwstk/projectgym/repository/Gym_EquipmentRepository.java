package pl.edu.pjwstk.projectgym.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projectgym.model.Gym_Equipment;

import java.util.List;

@Repository
public interface Gym_EquipmentRepository extends JpaRepository<Gym_Equipment,Long> {
    List<Gym_Equipment>findGym_EquipmentByMachine(String machine);

}
