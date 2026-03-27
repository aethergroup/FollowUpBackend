package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.domain.model.Gym;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface GymService {

    void save(Gym gym);

    void update(Gym gym);

    void delete(Integer id);

    List<Gym> findAll();

    @Transactional(readOnly = true)
    Optional<Gym> findById(Integer id);

}
