package com.animeslist.animeslist.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record AnimeResponse(
        Long id,
        String tittle,
        String description,
        LocalDate releaseDate,
        double rating,
        List<CategoryResponse> categoryResponseList,
        List<StreamingResponse> streamingResponses
) {
}
