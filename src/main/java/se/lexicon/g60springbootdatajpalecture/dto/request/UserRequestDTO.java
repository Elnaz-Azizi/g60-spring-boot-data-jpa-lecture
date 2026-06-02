package se.lexicon.g60springbootdatajpalecture.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank(message = "Email is required")
        @Size(max = 100, message = "Email must not exceed 100 characters")
        @Email(message = "Invalid email format", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        String email,

        @NotBlank(message = "Full Name is required")
        @Size(max = 100, message = "Full Name must not exceed 100 characters")
        String fullName
) {
}
