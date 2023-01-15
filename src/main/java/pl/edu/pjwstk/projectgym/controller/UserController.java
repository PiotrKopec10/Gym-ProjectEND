package pl.edu.pjwstk.projectgym.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.User;
import pl.edu.pjwstk.projectgym.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/User/")
public class UserController {
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){return ResponseEntity.ok(userService.getAllUser());}


}
