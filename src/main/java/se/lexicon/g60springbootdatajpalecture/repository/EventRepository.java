package se.lexicon.g60springbootdatajpalecture.repository;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import se.lexicon.g60springbootdatajpalecture.entity.Event;
import se.lexicon.g60springbootdatajpalecture.entity.EventStatus;

import java.time.LocalDateTime;
import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByTitleContaining(String title);

    List<Event> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Event> findByLocation(String location);

    List<Event> findByStatus(EventStatus status);
}