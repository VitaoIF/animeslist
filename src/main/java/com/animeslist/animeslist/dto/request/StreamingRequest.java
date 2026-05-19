package com.animeslist.animeslist.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@NotEmpty(message = "Informe o nome do streaming") String name) {
}
