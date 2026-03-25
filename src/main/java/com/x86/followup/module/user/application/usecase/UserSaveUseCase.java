package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSaveUseCase {

    private final UserRepository repository;

    public void execute(User user) {
        this.repository.save(user);
    }
}