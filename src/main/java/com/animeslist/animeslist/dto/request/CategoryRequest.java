package com.animeslist.animeslist.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Informe o nome da categoria") String name) {
}
