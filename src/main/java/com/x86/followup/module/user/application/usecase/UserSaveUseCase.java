package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.auth.domain.repository.AuthRepository;
import com.x86.followup.module.user.domain.exception.UserExistException;
import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserPassword;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSaveUseCase {

    private final UserRepository repository;
    private final AuthRepository authRepository;

    public void execute(User user) {

        repository.findByIdentification(user.getIdentification().getValue())
                .ifPresent(existingUser -> {
                    throw new UserExistException("Este usuario ya existe en nuestra plataforma");
                });

        String plainPassword = user.getPassword().getValue();

        String hashedPassword = authRepository.encode(plainPassword);

        user.setPassword(new UserPassword(hashedPassword));

        this.repository.save(user);
    }
}