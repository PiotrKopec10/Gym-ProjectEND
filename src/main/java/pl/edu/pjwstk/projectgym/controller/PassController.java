package pl.edu.pjwstk.projectgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.service.PassService;

import java.util.List;

@RestController
@RequestMapping("/api/Pass/")
public class PassController {
    PassService passService;

    @Autowired
    public PassController(PassService passService) {
        this.passService = passService;
    }

    @PostMapping
    public ResponseEntity<Pass> createPass(@RequestBody Pass pass){
        return ResponseEntity.ok(passService.createPass(pass));
    }

    @GetMapping
    public ResponseEntity<List<Pass>>getAllPass(){return ResponseEntity.ok(passService.getAllPass());}

    @GetMapping("/{id}")
    public ResponseEntity<Pass> getPassById(@PathVariable("id") Long id){
        return ResponseEntity.ok(passService.getPassById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePassById(@RequestParam("id") Long id){
        passService.deletePassById(id);
        return ResponseEntity.ok("ok");
    }
}
