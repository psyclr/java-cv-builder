package com.alex.cv.dto;

import java.util.List;

public record UserDto(
        Long id,
        String firstName,
        String lastName,
        List<SkillDto> skills
) {
}
