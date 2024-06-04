package com.maa.as5.as5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maa.as5.as5.entity.dto.input.LoginRequest;
import com.maa.as5.as5.entity.dto.input.RefreshTokenRequest;
import com.maa.as5.as5.entity.dto.output.LoginResponse;
import com.maa.as5.as5.service.AuthService;

@RestController
@RequestMapping("api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

}