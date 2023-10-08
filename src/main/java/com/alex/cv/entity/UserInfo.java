package com.alex.cv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users-info")
@Getter
@Setter
public class UserInfo extends AbstractEntity {
    private String firstName;
    private String lastName;
    private int age;
}
