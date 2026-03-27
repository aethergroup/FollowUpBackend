package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GymFindAllUseCase {

    private final GymRepository repository;

    public List<Gym> execute(){
        return repository.findAll();
    }

}
