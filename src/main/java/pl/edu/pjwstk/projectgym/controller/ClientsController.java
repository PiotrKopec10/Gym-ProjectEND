package pl.edu.pjwstk.projectgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.Clients;
import pl.edu.pjwstk.projectgym.service.ClientsService;

import java.util.List;

@RestController
@RequestMapping("/api/Clients/")
public class ClientsController {
   ClientsService clientsService;

   @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public ResponseEntity<List<Clients>>getAllClients(){return ResponseEntity.ok(clientsService.getAllClients());}


    @PostMapping
    public ResponseEntity<Clients> createClient(@RequestBody Clients clients){
        return ResponseEntity.ok(clientsService.createClient(clients));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientsById(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientsService.getClientsById(id));
    }


    @DeleteMapping
    public ResponseEntity<String> deleteClientsById(@RequestParam("id") Long id){
        clientsService.deleteClientsById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{name}/{surname}")
    public  ResponseEntity<Clients>findClientsByNameAndSurname(@PathVariable("name")String name,@PathVariable("surname")String surname){
       return ResponseEntity.ok(clientsService.findByNameAndLastName(name, surname));
    }



}
