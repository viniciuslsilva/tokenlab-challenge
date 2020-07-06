package br.com.tokenlab.challenge.dto;

import java.time.LocalDateTime;

public class EventDTOBuilder {
    private Long id;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;

    public EventDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public EventDTOBuilder description(String description) {
        this.description = description;
        return this;
    }

    public EventDTOBuilder dateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public EventDTOBuilder dateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public EventDTO build() {
        return new EventDTO(id, description, dateStart,dateEnd);
    }

}
