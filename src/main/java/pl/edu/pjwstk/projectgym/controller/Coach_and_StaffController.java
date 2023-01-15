package pl.edu.pjwstk.projectgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.Coach_and_Staff;
import pl.edu.pjwstk.projectgym.service.Coach_and_StaffService;

import java.util.List;

@RestController
@RequestMapping("/api/CoachAndStaff/")
public class Coach_and_StaffController {
    Coach_and_StaffService coach_and_staffService;

    @Autowired
    public Coach_and_StaffController(Coach_and_StaffService coach_and_staffService) {
        this.coach_and_staffService = coach_and_staffService;
    }
    @GetMapping("/{name}/{surname}")
    public ResponseEntity<Coach_and_Staff> findByNameAndLastName(@PathVariable("name")String name, @PathVariable("surname")String surname){
        return ResponseEntity.ok(coach_and_staffService.findByNameAndLastName(name, surname));
    }
    @PostMapping
    public ResponseEntity<Coach_and_Staff> createCoach_and_Staff(@RequestBody Coach_and_Staff coach_and_staff){
        return ResponseEntity.ok(coach_and_staffService.createCoach_and_Staff(coach_and_staff));
    }
    @GetMapping
    public ResponseEntity<List<Coach_and_Staff>>getAllCoach_and_Staff(){return ResponseEntity.ok(coach_and_staffService.getAllCoach_and_Staff());}

    @GetMapping("/{id}")
    public ResponseEntity<Coach_and_Staff> getCoach_and_StaffById(@PathVariable("id") Long id){
        return ResponseEntity.ok(coach_and_staffService.getCoach_and_StaffById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCoach_and_StaffById(@RequestParam("id") Long id){
        coach_and_staffService.deleteCoach_and_StaffById(id);
        return ResponseEntity.ok("ok");
    }
}
