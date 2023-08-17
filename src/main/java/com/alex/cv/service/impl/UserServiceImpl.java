package com.alex.cv.service.impl;

import java.util.stream.Collectors;

import com.alex.cv.dto.SkillDto;
import com.alex.cv.dto.UserDto;
import com.alex.cv.entity.SkillEntity;
import com.alex.cv.entity.UserEntity;
import com.alex.cv.exception.ResourceNotFoundException;
import com.alex.cv.repository.UserRepository;
import com.alex.cv.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDto addSkill(Long id, SkillDto dto) {
        var user = getUserById(id);

        var skillEntity = new SkillEntity();
        skillEntity.setName(dto.getName());
        skillEntity.setDescription(dto.getDescription());
        skillEntity.setUser(user);
        user.getSkills().add(skillEntity);

        var skillDtoList = user.getSkills().stream()
                .map(s -> new SkillDto(s.getName(), s.getDescription())).collect(Collectors.toList());

        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), skillDtoList);
    }

    private UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }
}
