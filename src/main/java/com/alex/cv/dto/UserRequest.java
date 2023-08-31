package com.alex.cv.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    Long id;
    String firstName;
    String lastName;
    List<SkillDto> skills;
}
