package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.auth.domain.repository.AuthRepository;
import com.x86.followup.module.user.domain.exception.UserNotFoundError;
import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserPassword;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUpdateUseCase {

    private final UserRepository repository;
    private final AuthRepository authRepository;

    public void execute(User user) {
        if (user.getId() == null || repository.findById(user.getId()).isEmpty()) {
            throw new UserNotFoundError("No se puede actualizar: Usuario con ID "
                    + (user.getId() != null ? user.getId().getValue() : "null")
                    + " no encontrado.");
        }

        String plainPassword = user.getPassword().getValue();
        String hashedPassword = authRepository.encode(plainPassword);

        user.setPassword(new UserPassword(hashedPassword));

        this.repository.update(user);
    }
}