package pl.edu.pjwstk.projectgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projectgym.model.Events;
import pl.edu.pjwstk.projectgym.model.Pass;
import pl.edu.pjwstk.projectgym.repository.EventsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {
    EventsRepository eventsRepository;

    @Autowired
    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    public Events createEvent(Events events){
        return eventsRepository.save(events);
    }

    public Events findEventsByNameOfEvent(String nameOfEvent){
        Optional<Events> events = eventsRepository.findEventsByNameOfEvent(nameOfEvent);
        if(events.isPresent()){
            return events.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Events> getAllEvents(){
        return eventsRepository.findAll();
    }

    public Events getEventById(Long id){
        Optional<Events> idEvents = eventsRepository.findById(id);
        if (idEvents.isPresent()){
            return idEvents.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteEventById(Long id){
        eventsRepository.deleteById(id);
    }
}
