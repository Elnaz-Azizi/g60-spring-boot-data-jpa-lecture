package se.lexicon.g60springbootdatajpalecture.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventRequestDTO (

        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title must not exceed 255 characters")
        String title,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description,

        @NotBlank(message = "Location cannot be blank")
        @Size(max = 255, message = "Location must not exceed 255 characters")
        String location,

        @NotNull(message = "Date and Time cannot be null")
        @FutureOrPresent(message = "Date and Time must be in the future")
        LocalDateTime dateTime,

        @NotBlank(message = "Status is required")
        String status,

        @NotNull(message = "Created By User Id is required")
        Long createdByUserId

){


}

// @NotNull
//Validates that the value is not null.
//Allows empty strings ("") and strings containing only spaces ("   ").
//Use when the field must exist, but its content is not validated.

//@NotEmpty
//Validates that the value is not null and not empty.
//For strings, "" is invalid, but "   " (spaces only) is valid.
//Also works with collections, maps, and arrays to ensure they contain at least one element.

//@NotBlank
//Validates that the string is not null, not empty, and not whitespace only.
//Trims whitespace before checking the value.
//Best choice for required text fields such as names, usernames, and comments.