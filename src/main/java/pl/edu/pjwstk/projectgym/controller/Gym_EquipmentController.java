package pl.edu.pjwstk.projectgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.Gym_Equipment;
import pl.edu.pjwstk.projectgym.service.Gym_EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/Equipment/")
public class Gym_EquipmentController {
    Gym_EquipmentService gym_equipmentService;

    @Autowired
    public Gym_EquipmentController(Gym_EquipmentService gym_equipmentService) {
        this.gym_equipmentService = gym_equipmentService;
    }

    @PostMapping
    public ResponseEntity<Gym_Equipment> createGym_Equipment(@RequestBody Gym_Equipment gym_equipment){
        return ResponseEntity.ok(gym_equipmentService.createGym_Equipment(gym_equipment));
    }

    @GetMapping
    public ResponseEntity<List<Gym_Equipment>>getAllGym_Equipment(){return ResponseEntity.ok(gym_equipmentService.getAllGym_Equipment());}


    @GetMapping("/{id}")
    public ResponseEntity<Gym_Equipment> getGym_EquipmentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(gym_equipmentService.getGym_EquipmentById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGym_EquipmentById(@RequestParam("id") Long id){
        gym_equipmentService.deleteGym_EquipmentById(id);
        return ResponseEntity.ok("ok");
    }
}
