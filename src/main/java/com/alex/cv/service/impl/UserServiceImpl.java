package com.alex.cv.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.alex.cv.dto.SkillDto;
import com.alex.cv.dto.UserRequest;
import com.alex.cv.dto.UserResponse;
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

    private static List<SkillDto> mapSkillsToDto(List<SkillEntity> skills) {
        return skills.stream()
                .map(s -> new SkillDto(s.getName(), s.getDescription())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponse addSkill(Long id, SkillDto dto) {
        var user = getUserByIdOrThrow(id);

        var skillEntity = new SkillEntity();
        skillEntity.setName(dto.getName());
        skillEntity.setDescription(dto.getDescription());
        skillEntity.setUser(user);
        user.getSkills().add(skillEntity);

        List<SkillDto> skillDtoList = mapSkillsToDto(user.getSkills());

        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), skillDtoList);
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {

        var user = new UserEntity();
        user.setSkills(request.getSkills().stream().map(skillDto -> new SkillEntity()).toList());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), mapSkillsToDto(user.getSkills()));
    }

    private UserEntity getUserByIdOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }
}
