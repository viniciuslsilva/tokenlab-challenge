package br.com.tokenlab.challenge.repository;

import br.com.tokenlab.challenge.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
