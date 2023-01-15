package pl.edu.pjwstk.projectgym.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.projectgym.model.enums.GENDER;



@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @OneToOne(fetch = FetchType.EAGER)
    private Pass pass;

    public Clients() {
    }

    public Clients(Long id, String name, String surname, GENDER gender,Pass pass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.pass= pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}
