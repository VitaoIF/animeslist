package com.animeslist.animeslist.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record AnimeRequest(String tittle,
                           String description,

                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,

                           double raiting,
                           List<Long> categories,
                           List<Long> streamings) {
}
