package br.com.tokenlab.challenge.service;

import br.com.tokenlab.challenge.dto.EventDTO;
import br.com.tokenlab.challenge.entity.Event;
import br.com.tokenlab.challenge.exception.GenericResourceException;
import br.com.tokenlab.challenge.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO save(Event event) {
        Event createdEvent = eventRepository.save(event);
        return new EventDTO(createdEvent);
    }

    @Override
    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(EventDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EventDTO> findById(Long id) {
        return eventRepository.findById(id).map(EventDTO::new);
    }

    @Override
    public EventDTO update(Long id, EventDTO eventDTO) {
        Event foundEvent = eventRepository.findById(id)
                .orElseThrow(() -> new GenericResourceException("Not found event with id " + id,
                        "Not found resource in database with parameters informed"));
        foundEvent.update(eventDTO);
        Event updatedEvent = eventRepository.save(foundEvent);
        return new EventDTO(updatedEvent);
    }

    @Override
    public void deleteById(Long id) {
        Event foundEvent = eventRepository.findById(id)
                .orElseThrow(() -> new GenericResourceException("Not found event with id " + id,
                        "Not found resource in database with parameters informed"));
        eventRepository.delete(foundEvent);
    }
}
