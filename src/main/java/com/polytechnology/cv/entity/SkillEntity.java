package com.polytechnology.cv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class SkillEntity extends AbstractEntity {
    @ManyToOne
    private UserEntity user;

    private String name;
    private String description;
}
