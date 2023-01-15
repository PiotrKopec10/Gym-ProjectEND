package pl.edu.pjwstk.projectgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Coach_and_Staff;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.repository.Coach_and_StaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Coach_and_StaffService {
    Coach_and_StaffRepository coach_and_staffRepository;

    @Autowired
    public Coach_and_StaffService(Coach_and_StaffRepository coach_and_staffRepository) {
        this.coach_and_staffRepository = coach_and_staffRepository;
    }


    public Coach_and_Staff createCoach_and_Staff(Coach_and_Staff coach_and_staff){
        return coach_and_staffRepository.save(coach_and_staff);
    }

    public Coach_and_Staff findByNameAndLastName(String name, String surname){
        Optional<Coach_and_Staff> coach_and_staff = coach_and_staffRepository.findCoach_and_StaffByNameAndSurname(name, surname);
        if(coach_and_staff.isPresent()){
            return coach_and_staff.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Coach_and_Staff> getAllCoach_and_Staff(){
        return coach_and_staffRepository.findAll();
    }

    public Coach_and_Staff getCoach_and_StaffById(Long id){
        Optional<Coach_and_Staff> idCoachAndStaff = coach_and_staffRepository.findById(id);
        if (idCoachAndStaff.isPresent()){
            return idCoachAndStaff.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteCoach_and_StaffById(Long id){
        coach_and_staffRepository.deleteById(id);
    }
}
