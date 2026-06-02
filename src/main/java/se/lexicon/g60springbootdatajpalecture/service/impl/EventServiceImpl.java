package se.lexicon.g60springbootdatajpalecture.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g60springbootdatajpalecture.dto.request.EventRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.EventResponseDTO;
import se.lexicon.g60springbootdatajpalecture.entity.Event;
import se.lexicon.g60springbootdatajpalecture.entity.User;
import se.lexicon.g60springbootdatajpalecture.exception.DataNotFoundException;
import se.lexicon.g60springbootdatajpalecture.mapper.EntityToDtoMapper;
import se.lexicon.g60springbootdatajpalecture.repository.EventRepository;
import se.lexicon.g60springbootdatajpalecture.repository.UserRepository;
import se.lexicon.g60springbootdatajpalecture.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final EntityToDtoMapper mapper;

    public EventServiceImpl(UserRepository userRepository, EventRepository eventRepository, EntityToDtoMapper mapper) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }
    @Override
    @Transactional
    public EventResponseDTO create(EventRequestDTO eventRequestDTO) {
        if (eventRequestDTO == null) throw new IllegalArgumentException("EventRequestDTO cannot be null");
        User userCreator = userRepository.findById(eventRequestDTO.createdByUserId())
                .orElseThrow(() -> new DataNotFoundException("Creator user not found with ID: " + eventRequestDTO.createdByUserId()));

    Event event = mapper.toEventEntity(eventRequestDTO);
    event.setCreatedBy(userCreator);
    Event savedEvent = eventRepository.save(event);

    return mapper.toEventResponseDTO(savedEvent);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<EventResponseDTO> findById(Long id) {
        return eventRepository.findById(id).map(mapper::toEventResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventResponseDTO> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(mapper::toEventResponseDTO)
                .toList();

    }

    @Override
    public void addParticipant(Long eventId, Long participantId) {
        if (eventId == null || participantId == null)
            throw new IllegalArgumentException("Event ID or participant ID cannot be null.");
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new DataNotFoundException("Event not found with ID: " + eventId));
        User participant = userRepository.findById(participantId)
                .orElseThrow(() -> new DataNotFoundException("User not found with ID: " + participantId));

        event.addParticipant(participant);
        eventRepository.save(event);
    }
}
