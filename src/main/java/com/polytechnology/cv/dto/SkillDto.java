package com.polytechnology.cv.dto;

import jakarta.validation.constraints.NotEmpty;

public record SkillDto(
        @NotEmpty String name,
        String description) {
}
