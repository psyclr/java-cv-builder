package com.polytechnology.cv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    String email;
    String password;
    String firstName;
    String lastName;
}
