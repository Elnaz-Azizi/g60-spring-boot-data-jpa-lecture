package se.lexicon.g60springbootdatajpalecture.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record EventResponseDTO(
        Long id,
        String title,
        String description,
        LocalDateTime dateTime,
        String location,
        String status,
        UserResponseDTO createdBy,
        Set<UserResponseDTO> participants
) {
}
