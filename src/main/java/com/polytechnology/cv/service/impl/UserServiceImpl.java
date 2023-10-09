package com.polytechnology.cv.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.polytechnology.cv.dto.SkillDto;
import com.polytechnology.cv.dto.UserInfoDto;
import com.polytechnology.cv.dto.UserRequest;
import com.polytechnology.cv.dto.UserResponse;
import com.polytechnology.cv.entity.SkillEntity;
import com.polytechnology.cv.entity.UserEntity;
import com.polytechnology.cv.entity.UserInfoEntity;
import com.polytechnology.cv.exception.ResourceNotFoundException;
import com.polytechnology.cv.repository.UserRepository;
import com.polytechnology.cv.service.UserInfoService;
import com.polytechnology.cv.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoService userInfoService;

    private static UserResponse createUserResponse(UserEntity user, UserInfoEntity user1) {
        return new UserResponse(user.getId(),
                user1.getFirstname(),
                user1.getLastname(),
                mapSkillsToDto(user.getSkills()));
    }

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

        var userInfo = user.getUserInfoEntity();
        return createUserResponse(user, userInfo);
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {

        var user = new UserEntity();
        user.setSkills(request.getSkills().stream().map(skillDto -> new SkillEntity()).toList());

        var userInfo = userInfoService.saveUserInfo(new UserInfoDto(request.getFirstName(), request.getLastName()));
        user.setUserInfoEntity(userInfo);

        return createUserResponse(user, user.getUserInfoEntity());
    }

    private UserEntity getUserByIdOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
