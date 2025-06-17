package com.ez.crm.module.client.core.dto.request;

import com.ez.crm.module.client.core.enums.LanguageEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Map;
@Data
public class ClientUpdateRequest {


    @NotBlank
    private LanguageEnum language;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private Map<String, String> metadata;
}
