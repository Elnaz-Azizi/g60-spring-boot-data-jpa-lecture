package se.lexicon.g60springbootdatajpalecture.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g60springbootdatajpalecture.dto.request.UserRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.UserResponseDTO;
import se.lexicon.g60springbootdatajpalecture.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
//localhost:8080/api/v1/users
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO dto) {
        System.out.println("request body: " + dto);
        UserResponseDTO response = userService.register(dto);
        System.out.println("response body: " + response);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    /* Request body
    "email":"value",
    "FullName":""value

    Response Body:
    {
    "id" : 0,
    "email": "value",
    "fullName": "value"
    "createdDate": "value"
    }

     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable @Positive(message= "id must be a positive number") Long id) {
        System.out.println("id: " + id);
        UserResponseDTO response = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }

    //Get - http:localhost:8080/api/v1/users
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> response = userService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
    }
}
