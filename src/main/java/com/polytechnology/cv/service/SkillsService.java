package com.polytechnology.cv.service;

import java.util.Set;

import com.polytechnology.cv.dto.SkillDto;

public interface SkillsService {
    void addSkillSetToUser(Set<SkillDto> skillDtoSet, Long userId);
}
