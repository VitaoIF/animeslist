package com.animeslist.animeslist.dto.request;

import java.time.LocalDate;
import java.util.List;

public record AnimeRequest(String tittle,
                           String description,
                           LocalDate releaseDate,
                           double raiting,
                           List<Long> categories,
                           List<Long> streamings) {
}
