package com.polytechnology.cv.service;

import com.polytechnology.cv.dto.UserInfoDto;
import com.polytechnology.cv.entity.UserInfoEntity;

public interface UserInfoService {

    UserInfoEntity saveUserInfo(UserInfoDto userInfoDto);
}
