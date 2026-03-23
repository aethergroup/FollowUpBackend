package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserIdentification;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserFindByIdentificationUseCase {
    private final UserRepository repository;

    public Optional<User> execute(String identificationNumber) {
        return repository.findByIdentification(new UserIdentification(identificationNumber));
    }
}