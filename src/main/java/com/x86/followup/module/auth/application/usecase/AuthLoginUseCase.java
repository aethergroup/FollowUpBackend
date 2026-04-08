package com.x86.followup.module.auth.application.usecase;

import com.x86.followup.module.auth.domain.exception.InvalidCredentialException;
import com.x86.followup.module.auth.domain.repository.AuthRepository;
import com.x86.followup.module.auth.domain.repository.TokenService;
import com.x86.followup.module.auth.infrastructure.controller.dto.LoginResponse;
import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthLoginUseCase {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final TokenService tokenService;

    public LoginResponse execute(String identification, String plainPassword) {
        User user = userRepository.findByIdentification(identification)
                .orElseThrow(() -> new InvalidCredentialException("Credenciales invalidas"));

        boolean isValid = authRepository.matches(plainPassword, user.getPassword().getValue());

        if (!isValid) {
            throw new InvalidCredentialException("Credenciales invalidas");
        }

        String token = tokenService.generateToken(user);
        String rol = tokenService.getRoleFromToken(token);

        return new LoginResponse(token, "Bearer", rol);
    }
}