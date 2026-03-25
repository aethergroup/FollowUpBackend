package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserId;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserFindByIdUseCase {
    private final UserRepository repository;

    public Optional<User> execute(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return repository.findById(new UserId(id));
    }
}
