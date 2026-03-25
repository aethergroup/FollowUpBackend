package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserFindAllUseCase {
    private final UserRepository repository;

    public List<User> execute() {
        return repository.findAll();
    }
}
