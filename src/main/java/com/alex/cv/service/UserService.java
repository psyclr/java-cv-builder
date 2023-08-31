package com.alex.cv.service;

import com.alex.cv.dto.SkillDto;
import com.alex.cv.dto.UserRequest;
import com.alex.cv.dto.UserResponse;

public interface UserService {
    UserResponse addSkill(Long id, SkillDto dto);
    UserResponse createUser(UserRequest request);
}
