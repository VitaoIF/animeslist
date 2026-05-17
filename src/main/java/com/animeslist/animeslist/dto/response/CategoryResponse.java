package com.animeslist.animeslist.dto.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
