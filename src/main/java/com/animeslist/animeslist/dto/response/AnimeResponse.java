package com.animeslist.animeslist.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record AnimeResponse(
        Long id,
        String tittle,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        double rating,
        List<CategoryResponse> categoryResponseList,
        List<StreamingResponse> streamingResponses
) {
}
