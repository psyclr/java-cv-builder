package com.polytechnology.cv.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.polytechnology.cv.dto.SkillDto;
import com.polytechnology.cv.entity.SkillEntity;
import com.polytechnology.cv.repository.SkillRepository;
import com.polytechnology.cv.repository.UserRepository;
import com.polytechnology.cv.service.SkillsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillsServiceImpl implements SkillsService {

    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addSkillSetToUser(Set<SkillDto> skillDtoSet, Long userId) {
        var user = userRepository.findById(userId).orElseThrow();

        var skillEntitySet = skillDtoSet.stream()
                .map(skillDto -> {
                    SkillEntity skillEntity = new SkillEntity();
                    skillEntity.setDescription(skillDto.description());
                    skillEntity.setName(skillDto.name());
                    return skillEntity;
                })
                .collect(Collectors.toSet());

        var skillEntities = skillRepository.saveAll(skillEntitySet);
        user.setSkills(new HashSet<>(skillEntities));
    }
}
