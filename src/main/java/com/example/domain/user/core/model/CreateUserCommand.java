package com.example.domain.user.core.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class CreateUserCommand {
    @NotBlank
    private String name;

    private String about;

    private Integer age;

    private String birth;

    private Integer height;

    @NotBlank
    @Email
    private String email;

    private String password;

    private String phone;

    private String address;
}
