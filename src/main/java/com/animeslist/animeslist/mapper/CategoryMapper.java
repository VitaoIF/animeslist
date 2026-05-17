package com.animeslist.animeslist.mapper;

import com.animeslist.animeslist.dto.request.CategoryRequest;
import com.animeslist.animeslist.dto.response.CategoryResponse;
import com.animeslist.animeslist.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
