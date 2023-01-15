package pl.edu.pjwstk.projectgym.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.model.User;
import pl.edu.pjwstk.projectgym.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}
