package com.maa.as5.as5.service;

import com.maa.as5.as5.entity.dto.input.LoginRequest;
import com.maa.as5.as5.entity.dto.input.RefreshTokenRequest;
import com.maa.as5.as5.entity.dto.output.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
