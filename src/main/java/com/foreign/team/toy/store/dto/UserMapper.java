package com.foreign.team.toy.store.dto;

import com.foreign.team.toy.store.model.User;

public class UserMapper {

    public static User toEntity(UserRequest req) {
        return new User(req.username(), req.email(), req.password());
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
