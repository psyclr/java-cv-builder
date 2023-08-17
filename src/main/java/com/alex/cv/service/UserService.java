package com.alex.cv.service;

import com.alex.cv.dto.SkillDto;
import com.alex.cv.dto.UserDto;

public interface UserService {
    UserDto addSkill(Long id, SkillDto dto);
}
