package com.ez.crm.module.auth.controller;

import com.ez.crm.common.core.constant.ApiURL;
import com.ez.crm.common.core.response.ApiResponse;
import com.ez.crm.module.auth.dto.request.AuthRequest;
import com.ez.crm.module.auth.dto.response.AuthResponse;
import com.ez.crm.module.auth.service.AuthService;
import com.ez.crm.module.client.core.dto.request.ClientCreateRequest;
import com.ez.crm.module.client.core.dto.response.ClientResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApiURL.API_AUTH)
public class AuthController {
private final AuthService authService;
public AuthController(AuthService authService) {
    this.authService = authService;

}
    @PostMapping("")
    public ApiResponse<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        AuthResponse result = this.authService.login(request);

        return ApiResponse.ok(result);
    }
}
