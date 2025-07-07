package com.foreign.team.toy.store.dto;

import jakarta.validation.constraints.*;

public record CartRequest(
        @NotNull(message = "User ID is required")
        Long userId)
{
}
