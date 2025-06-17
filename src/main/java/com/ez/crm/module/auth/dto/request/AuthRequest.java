package com.ez.crm.module.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class AuthRequest {

//    @NotBlank
    @Email(message = "Invalid email format")
    private String email = "admin@gmail.com";

    //    @NotBlank
    private String password = "123456";
}
