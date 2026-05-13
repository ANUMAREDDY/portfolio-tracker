package com.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}
