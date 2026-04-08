package com.x86.followup.module.auth.infrastructure.controller;

import com.x86.followup.module.auth.application.usecase.AuthLoginUseCase;
import com.x86.followup.module.auth.infrastructure.controller.dto.LoginRequest;
import com.x86.followup.module.auth.infrastructure.controller.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthLoginUseCase authLoginUseCase;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authLoginUseCase.execute(
                request.identification(),
                request.password()
        );
        return ResponseEntity.ok(response);
    }
}