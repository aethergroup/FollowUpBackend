package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.exception.GymNotFoundException;
import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymUpdateUseCase {

    private final GymRepository repository;

    public void execute(Gym gym){
        if (gym.getId() == null || repository.findById(gym.getId()).isEmpty()) {
            throw new GymNotFoundException("No se puede actualizar: Gym con ID "
                    + (gym.getId() != null ? gym.getId().getValue() : "null")
                    + " no encontrado.");
        }
        this.repository.update(gym);
    }

}
