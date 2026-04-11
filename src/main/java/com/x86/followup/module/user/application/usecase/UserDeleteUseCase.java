package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.exception.UserNotFoundError;
import com.x86.followup.module.user.domain.model.UserId;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDeleteUseCase {
    private final UserRepository repository;

    public void execute(Integer id) {

        UserId userId = new UserId(id);

        if (!repository.findById(userId).isPresent()){
            throw new UserNotFoundError("Este usuario no existe en nuestra plataforma");
        }

        this.repository.delete(new UserId(id));
    }
}
