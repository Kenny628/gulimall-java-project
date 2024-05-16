package com._yzhheng.vo;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisVo {

    @NotBlank(message = "Must fill in username")
    @Length(min = 6, max = 18, message = "username must be 6-18 length")
    private String userName;
    @NotBlank(message = "Must fill in password")
    @Length(min = 6, max = 18, message = "Password must be 6-18 length")
    private String password;
    @NotBlank(message = "Must fill in code")
    private String code;
}
