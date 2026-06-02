package se.lexicon.g60springbootdatajpalecture.dto.response;

import java.time.Instant;

public record UserResponseDTO(
        Long id,
        String fullName,
        String email,
        Instant createDate
) {
}
