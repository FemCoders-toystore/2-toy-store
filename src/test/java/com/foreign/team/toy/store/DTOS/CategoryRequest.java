package com.foreign.team.toy.store.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "Category name cannot be blank")
        @Size(max = 30, message = "Category name cannot exceed 30 characters")
        String name) {

}