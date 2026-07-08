package com.healthcare.api.mapper;

import com.healthcare.api.dto.UserResponseDTO;
import com.healthcare.api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getMicroArea(),
                user.isActive()
        );
    }
}
