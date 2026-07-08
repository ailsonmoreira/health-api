package com.healthcare.api.service;

import com.healthcare.api.dto.UserCreateDTO;
import com.healthcare.api.dto.UserResponseDTO;
import com.healthcare.api.entity.User;
import com.healthcare.api.enums.Role;
import com.healthcare.api.mapper.UserMapper;
import com.healthcare.api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public UserService (
            UserRepository repository,
            UserMapper mapper,
            PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    public UserResponseDTO create (UserCreateDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(dto.name());
        user.setEmail(dto.email());

        user.setPassword(
                encoder.encode(dto.password())
        );

        user.setMicroArea(dto.microArea());

        //API should create only AGENT
        user.setRole(Role.AGENT);
        user.setActive(true);

        User saved = repository.save(user);

        return mapper.toResponse(saved);
    }

}
