package com.foreign.team.toy.store.dto;

import com.foreign.team.toy.store.model.User;

public class UserMapper {

    public static User toEntity(UserRequest req) {
        // Aquí creamos la entidad User a partir del DTO UserRequest
        return new User(req.username(), req.email(), req.password());
    }

    public static UserResponse toResponse(User user) {
        // Creamos el DTO de respuesta, sin password, solo datos públicos
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
