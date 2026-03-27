package com.x86.followup.module.gym.domain.repository;

import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.model.GymId;

import java.util.List;
import java.util.Optional;

public interface GymRepository {
    Gym save(Gym gym);
    void update (Gym gym);
    void delete(GymId id);

    List<Gym> findAll();
    Optional<Gym> findById(GymId id);

}
