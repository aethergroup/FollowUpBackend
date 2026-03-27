package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.GymId;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GymDeleteUseCase {

    private final GymRepository repository;

    public void execute(Integer id){
        this.repository.delete(new GymId(id));
    }
}
