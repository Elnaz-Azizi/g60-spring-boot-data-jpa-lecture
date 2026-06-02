package se.lexicon.g60springbootdatajpalecture.service.impl;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g60springbootdatajpalecture.dto.request.UserRequestDTO;
import se.lexicon.g60springbootdatajpalecture.dto.response.UserResponseDTO;
import se.lexicon.g60springbootdatajpalecture.entity.User;
import se.lexicon.g60springbootdatajpalecture.exception.DataNotFoundException;
import se.lexicon.g60springbootdatajpalecture.exception.DuplicateEntryException;
import se.lexicon.g60springbootdatajpalecture.mapper.EntityToDtoMapper;
import se.lexicon.g60springbootdatajpalecture.repository.UserRepository;
import se.lexicon.g60springbootdatajpalecture.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EntityToDtoMapper mapper;

    public UserServiceImpl(UserRepository userRepository, EntityToDtoMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserResponseDTO register(UserRequestDTO userRequestDto) {
        if (userRequestDto == null) throw new IllegalArgumentException("User Request cannot be null");
        if (userRepository.existsByEmail(userRequestDto.email())) {
            throw new DuplicateEntryException("User with email already exists");
        }
        User user = mapper.toUserEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return mapper.toUserResponseDTO(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponseDTO> findById(Long id) {
        return userRepository.findById(id).map(mapper::toUserResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toUserResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) throw new IllegalArgumentException("User ID cannot be null");
        if (!userRepository.existsById(id)) {
            throw new DataNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
