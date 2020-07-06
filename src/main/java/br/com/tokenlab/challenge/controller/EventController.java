package br.com.tokenlab.challenge.controller;

import br.com.tokenlab.challenge.dto.EventDTO;
import br.com.tokenlab.challenge.entity.Event;
import br.com.tokenlab.challenge.service.EventService;
import br.com.tokenlab.challenge.validator.EventDateValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @InitBinder("eventDTO")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new EventDateValidator());
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> listAll() {
        List<EventDTO> foundEvents = eventService.findAll();
        return ResponseEntity.ok(foundEvents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> findById(@PathVariable("id") Long id) {
        Optional<EventDTO> optionalFoundEvent = eventService.findById(id);
        return optionalFoundEvent.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<EventDTO> save(@Valid @RequestBody EventDTO eventDTO) {
        Event newEvent = eventDTO.newEvent();
        EventDTO createdEvent = eventService.save(newEvent);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable("id") Long id, @Valid @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.update(id, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        eventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
