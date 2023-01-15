package pl.edu.pjwstk.projectgym.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startdate;
    private String category;
    private LocalDateTime validation;

    @OneToOne(fetch = FetchType.EAGER)
    private Clients clients;

    public Pass() {
    }

    public Pass(Long id, LocalDateTime startdate, String category, LocalDateTime validation,Clients clients) {
        this.id = id;
        this.startdate = startdate;
        this.category = category;
        this.validation = validation;
        this.clients=clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public LocalDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getValidation() {
        return validation;
    }

    public void setValidation(LocalDateTime validation) {
        this.validation = validation;
    }
}
