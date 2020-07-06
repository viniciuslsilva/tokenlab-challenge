package br.com.tokenlab.challenge.entity;

import br.com.tokenlab.challenge.dto.EventDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false )
    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @NotNull
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

    public void update(EventDTO eventDTO) {
        this.description = eventDTO.getDescription();
        this.dateStart = eventDTO.getDateStart();
        this.dateEnd = eventDTO.getDateEnd();
    }
}
