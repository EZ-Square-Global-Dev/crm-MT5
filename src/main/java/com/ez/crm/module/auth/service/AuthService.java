package com.ez.crm.module.auth.service;

import com.ez.crm.module.auth.dto.request.AuthRequest;
import com.ez.crm.module.auth.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);
}
