package br.com.tokenlab.challenge.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false )
    private Long id;

    @NotBlank
    private String description;


    @Column(name = "date_start")
    private LocalDateTime dateStart;


    @Column(name = "date_end")
    private LocalDateTime dateEnd;

    public Event(String description, LocalDateTime dateStart, LocalDateTime dateEnd) {
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    @Deprecated
    public Event() { }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }
}
