package br.com.tokenlab.challenge.dto;


import br.com.tokenlab.challenge.entity.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class EventDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateStart;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateEnd;

    public EventDTO(Long id, @NotBlank String description, @NotNull LocalDateTime dateStart, @NotNull LocalDateTime dateEnd) {
        this.id = id;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public EventDTO(Event event) {
        this.id = event.getId();
        this.description = event.getDescription();
        this.dateStart = event.getDateStart();
        this.dateEnd = event.getDateEnd();
    }

    public Event newEvent() {
        return new Event(description, dateStart, dateEnd);
    }

    @Deprecated
    public EventDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public static EventDTOBuilder builder() {
        return new EventDTOBuilder();
    }

}
