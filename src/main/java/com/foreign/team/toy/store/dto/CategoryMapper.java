package com.foreign.team.toy.store.dto;

import com.foreign.team.toy.store.model.Category;

public class CategoryMapper {

    public static Category dtoToEntity(CategoryRequest dto) {
        Category category = new Category();
        category.setName(dto.name());
        return category;
    }

    public static CategoryResponse entityToDto(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}