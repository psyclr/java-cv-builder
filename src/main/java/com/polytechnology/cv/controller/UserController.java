package com.polytechnology.cv.controller;

import com.polytechnology.cv.dto.SkillDto;
import com.polytechnology.cv.dto.UserRequest;
import com.polytechnology.cv.dto.UserResponse;
import com.polytechnology.cv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/{id}/skill/")
    public UserResponse addSkillToUser(@PathVariable Long id, @RequestBody @Validated SkillDto skill) {
        return userService.addSkill(id, skill);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Validated UserRequest user) {
        return userService.createUser(user);
    }
}
