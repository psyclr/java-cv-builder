package com.polytechnology.cv.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends AbstractEntity {
    private String email;
    private String password;
    private String role;

    @OneToOne
    private UserInfoEntity userInfoEntity;

    @OneToMany
    private Set<SkillEntity> skills;
}