package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.model.GymId;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GymFindByIdUseCase {

    private final GymRepository repository;

    public Optional<Gym> execute(Integer id){
        if (id == null){
            return Optional.empty();
        }
        return repository.findById(new GymId(id));
    }

}
