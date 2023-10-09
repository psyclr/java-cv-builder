package com.polytechnology.cv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users-info")
@Getter
@Setter
public class UserInfoEntity extends AbstractEntity {

    private String firstname;
    private String lastname;
}
