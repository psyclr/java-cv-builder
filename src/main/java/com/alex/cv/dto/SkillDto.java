package com.alex.cv.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillDto {
    @NotEmpty
    private String name;
    private String description;
}
