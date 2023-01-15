package pl.edu.pjwstk.projectgym.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.projectgym.model.enums.GENDER;
import pl.edu.pjwstk.projectgym.model.enums.Staff_Type;

@Entity
public class Coach_and_Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    @Enumerated(EnumType.STRING)
    private Staff_Type staff_type;

    @ManyToOne
    @JoinColumn(name ="clients_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Clients clients;

    @ManyToOne
    @JoinColumn(name = "gym_equipment_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Gym_Equipment gym_equipment;

    public Coach_and_Staff(Long id, String name, String surname, GENDER gender, Staff_Type staff_type,Clients clients,Gym_Equipment gym_equipment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.staff_type = staff_type;
        this.clients=clients;
        this.gym_equipment= gym_equipment;
    }

    public Coach_and_Staff() {
    }

    public Long getId()   {
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

    public Staff_Type getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(Staff_Type staff_type) {
        this.staff_type = staff_type;
    }

}
