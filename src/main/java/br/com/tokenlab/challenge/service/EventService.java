package br.com.tokenlab.challenge.service;

import br.com.tokenlab.challenge.dto.EventDTO;
import br.com.tokenlab.challenge.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    EventDTO save(Event event);

    List<EventDTO> findAll();

    Optional<EventDTO> findById(Long id);

    EventDTO update(Long id, EventDTO eventDTO);

    void deleteById(Long id);
}
