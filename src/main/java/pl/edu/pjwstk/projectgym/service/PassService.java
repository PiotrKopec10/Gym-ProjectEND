package pl.edu.pjwstk.projectgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Clients;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.repository.PassRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassService {
    PassRepository passRepository;

    @Autowired
    public PassService(PassRepository passRepositoryl) {
        this.passRepository = passRepositoryl;
    }



    public Pass createPass(Pass pass){
        return passRepository.save(pass);
    }


    public List<Pass> getAllPass(){
        return passRepository.findAll();
    }

    public Pass getPassById(Long id){
        Optional<Pass> idPass = passRepository.findById(id);
        if (idPass.isPresent()){
            return idPass.get();
        }
        throw new IllegalArgumentException();
    }

    public void deletePassById(Long id){passRepository.deleteById(id);
    }
}
