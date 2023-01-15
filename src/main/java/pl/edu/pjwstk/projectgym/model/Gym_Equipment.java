package pl.edu.pjwstk.projectgym.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.projectgym.model.enums.Usage_of_Machine;

@Entity
public class Gym_Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String machine;
    @Enumerated(EnumType.STRING)
    private Usage_of_Machine usage;

    public Gym_Equipment() {
    }

    public Gym_Equipment(Long id, String machine, Usage_of_Machine usage) {
        this.id = id;
        this.machine = machine;
        this.usage = usage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public Usage_of_Machine getUsage() {
        return usage;
    }

    public void setUsage(Usage_of_Machine usage) {
        this.usage = usage;
    }
}
