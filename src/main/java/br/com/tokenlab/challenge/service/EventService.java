package br.com.tokenlab.challenge.service;

import br.com.tokenlab.challenge.entity.Event;
import br.com.tokenlab.challenge.dto.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO save(Event event);

    List<EventDTO> findAll();

    EventDTO findById(Long id);

}
