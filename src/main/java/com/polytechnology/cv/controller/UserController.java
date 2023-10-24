package com.polytechnology.cv.controller;

import java.net.URI;
import java.util.Set;

import com.polytechnology.cv.dto.SkillDto;
import com.polytechnology.cv.dto.UserRequest;
import com.polytechnology.cv.dto.UserResponse;
import com.polytechnology.cv.service.SkillsService;
import com.polytechnology.cv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final SkillsService skillsService;

    @PostMapping("/{id}/skills/")
    public ResponseEntity<Object> addSkillToUser(@PathVariable Long id, @RequestBody Set<SkillDto> skills) {
        skillsService.addSkillSetToUser(skills, id);
        return ResponseEntity.created(URI.create(String.valueOf(id))).build();

    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Validated UserRequest user) {
        return userService.createUser(user);
    }
}
