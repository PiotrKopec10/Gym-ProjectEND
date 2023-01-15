package pl.edu.pjwstk.projectgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Clients;
import pl.edu.pjwstk.projectgym.repository.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

  ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }



    public Clients createClient(Clients clients){
        return clientsRepository.save(clients);
    }

    public Clients findByNameAndLastName(String name, String surname){
        Optional<Clients> clients = clientsRepository.findClientsByNameAndSurname(name, surname);
        if(clients.isPresent()){
            return clients.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Clients> getAllClients(){
        return clientsRepository.findAll();
    }

    public Clients getClientsById(Long id){
       Optional<Clients>idClient = clientsRepository.findById(id);
       if (idClient.isPresent()){
           return idClient.get();
       }
       throw new IllegalArgumentException();
    }

    public void deleteClientsById(Long id){
        clientsRepository.deleteById(id);
    }
}
