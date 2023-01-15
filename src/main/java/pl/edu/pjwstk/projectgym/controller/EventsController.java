package pl.edu.pjwstk.projectgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projectgym.model.Events;
import pl.edu.pjwstk.projectgym.service.EventsService;

import java.util.List;

@RestController
@RequestMapping("/api/Events/")
public class EventsController {
    EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody Events events){
        return ResponseEntity.ok(eventsService.createEvent(events));
    }

    @GetMapping("/{name_of_event}")
    public ResponseEntity<Events> findEventsByNameOfEvent(@PathVariable("name_of_event")String nameOfEvent){
        return ResponseEntity.ok(eventsService.findEventsByNameOfEvent(nameOfEvent));
    }
    @GetMapping
    public ResponseEntity<List<Events>>getAllEvents(){return ResponseEntity.ok(eventsService.getAllEvents());}

    @GetMapping("/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventsService.getEventById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEventById(@RequestParam("id") Long id){
        eventsService.deleteEventById(id);
        return ResponseEntity.ok("ok");
    }



}
