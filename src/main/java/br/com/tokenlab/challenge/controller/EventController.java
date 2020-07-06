package br.com.tokenlab.challenge.controller;

import br.com.tokenlab.challenge.dto.EventDTO;
import br.com.tokenlab.challenge.entity.Event;
import br.com.tokenlab.challenge.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> listAll() {
        List<EventDTO> foundEvents = eventService.findAll();
        return ResponseEntity.ok(foundEvents);
    }

    @PostMapping
    public ResponseEntity<EventDTO> save(@Valid @RequestBody EventDTO eventDTO) {
        Event newEvent = eventDTO.newEvent();
        EventDTO createdEvent = eventService.save(newEvent);

        return ResponseEntity.ok(createdEvent);
    }
}
