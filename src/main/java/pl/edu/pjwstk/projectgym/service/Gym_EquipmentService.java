package pl.edu.pjwstk.projectgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Gym_Equipment;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.repository.Gym_EquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Gym_EquipmentService {
   Gym_EquipmentRepository gym_equipmentRepository;

    @Autowired
    public Gym_EquipmentService(Gym_EquipmentRepository gym_equipmentRepository) {
        this.gym_equipmentRepository = gym_equipmentRepository;
    }

    public Gym_Equipment createGym_Equipment(Gym_Equipment gym_equipment){
        return gym_equipmentRepository.save(gym_equipment);
    }


    public List<Gym_Equipment> getAllGym_Equipment(){
        return gym_equipmentRepository.findAll();
    }

    public Gym_Equipment getGym_EquipmentById(Long id){
        Optional<Gym_Equipment> idGymEq = gym_equipmentRepository.findById(id);
        if (idGymEq.isPresent()){
            return idGymEq.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteGym_EquipmentById(Long id){
        gym_equipmentRepository.deleteById(id);
    }
}
