package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymSaveUseCase {

    private final GymRepository repository;

    public void execute(Gym gym){
        this.repository.save(gym);
    }

}
