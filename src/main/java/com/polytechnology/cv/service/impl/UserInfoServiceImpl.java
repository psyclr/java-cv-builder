package com.polytechnology.cv.service.impl;

import com.polytechnology.cv.dto.UserInfoDto;
import com.polytechnology.cv.entity.UserInfoEntity;
import com.polytechnology.cv.repository.UserInfoRepository;
import com.polytechnology.cv.service.UserInfoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserInfoEntity saveUserInfo(UserInfoDto userInfoDto) {
        var userInfo = new UserInfoEntity();
        userInfo.setFirstname(userInfoDto.getFirstName());
        userInfo.setLastname(userInfoDto.getLastName());
        return userInfoRepository.save(userInfo);
    }
}
