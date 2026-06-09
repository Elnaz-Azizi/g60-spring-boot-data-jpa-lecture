package se.lexicon.g60springbootdatajpalecture.service;

import se.lexicon.g60springbootdatajpalecture.dto.request.UserRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDTO register(UserRequestDTO userRequestDto);

    UserResponseDTO update(Long id, UserRequestDTO userRequestDto);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    void deleteById(Long id);
}
