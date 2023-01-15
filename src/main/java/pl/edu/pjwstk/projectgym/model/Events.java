package pl.edu.pjwstk.projectgym.model;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;
    private LocalDateTime dateTime;
    private String nameOfEvent;
    private String prize_event;

    @ManyToOne
    @JoinColumn(name ="clients_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Clients clients;

    @ManyToOne
    @JoinColumn(name ="coach_and_staff_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Coach_and_Staff coach_and_staff;

    public Events(Long event_id, LocalDateTime dateTime, String nameOfEvent, String prize_event, Clients clients, Coach_and_Staff coach_and_staff) {
        this.event_id = event_id;
        this.dateTime = dateTime;
        this.nameOfEvent = nameOfEvent;
        this.prize_event = prize_event;
        this.clients=clients;
        this.coach_and_staff=coach_and_staff;
    }

    public Events() {
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getName_of_event() {
        return nameOfEvent;
    }

    public void setName_of_event(String name_of_event) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getPrize_event() {
        return prize_event;
    }

    public void setPrize_event(String prize_event) {
        this.prize_event = prize_event;
    }
}
