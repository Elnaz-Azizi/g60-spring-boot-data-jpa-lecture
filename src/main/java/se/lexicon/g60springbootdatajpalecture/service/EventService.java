package se.lexicon.g60springbootdatajpalecture.service;

import se.lexicon.g60springbootdatajpalecture.dto.request.EventRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.EventResponseDTO;

import java.util.List;
import java.util.Optional;

public interface EventService {

    EventResponseDTO create(EventRequestDTO eventRequestDTO);

    Optional<EventResponseDTO> findById(Long id);

    List<EventResponseDTO> findAll();

    void addParticipant(Long eventId, Long participantId);

    // Add other methods as needed

    void removeParticipant(Long eventId, Long participantId);
    List<EventResponseDTO> findByStatus(String status);
}
