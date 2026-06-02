package se.lexicon.g60springbootdatajpalecture.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.g60springbootdatajpalecture.dto.request.EventRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.EventResponseDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.UserResponseDTO;
import se.lexicon.g60springbootdatajpalecture.entity.Event;
import se.lexicon.g60springbootdatajpalecture.entity.EventStatus;
import se.lexicon.g60springbootdatajpalecture.entity.User;

import java.util.stream.Collectors;

@Component
public class EntityToDtoMapper {

    public UserResponseDTO toUserResponseDTO(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getCreateDate()
        );
    }

    public EventResponseDTO toEventResponseDTO(Event event) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDateTime(),
                event.getLocation(),
                event.getStatus().toString(),
                toUserResponseDTO(event.getCreatedBy()),
                event.getParticipants()
                        .stream()
                        .map(this::toUserResponseDTO)
                        .collect(Collectors.toSet())
        );
        return eventResponseDTO;
    }



    //The first method is to convert EventRequestDTO to Event entity
    public Event toEventEntity(EventRequestDTO eventRequestDTO) {
        if (eventRequestDTO == null) throw new IllegalArgumentException("Event Request cannot be null");

        Event event = new Event();
        event.setTitle(eventRequestDTO.title());
        event.setDescription(eventRequestDTO.description());
        event.setLocation(eventRequestDTO.location());
        event.setDateTime(eventRequestDTO.dateTime());
        event.setStatus(EventStatus.fromString(eventRequestDTO.status()));
        return event;
    }
}
