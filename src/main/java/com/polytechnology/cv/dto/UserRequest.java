package com.polytechnology.cv.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    String firstName;
    String lastName;
    List<SkillDto> skills;
}
