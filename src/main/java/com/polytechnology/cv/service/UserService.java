package com.polytechnology.cv.service;

import com.polytechnology.cv.dto.SkillDto;
import com.polytechnology.cv.dto.UserRequest;
import com.polytechnology.cv.dto.UserResponse;

public interface UserService {
    UserResponse addSkill(Long id, SkillDto dto);
    UserResponse createUser(UserRequest request);
}
