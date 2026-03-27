package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.application.usecase.*;
import com.x86.followup.module.gym.domain.model.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {

    private final GymSaveUseCase gymSaveUseCase;
    private final GymUpdateUseCase gymUpdateUseCase;
    private final GymDeleteUseCase gymDeleteUseCase;
    private final GymFindByIdUseCase gymFindByIdUseCase;
    private final GymFindAllUseCase gymFindAllUseCase;

    @Override
    @Transactional
    public void save(Gym gym) {
        gymSaveUseCase.execute(gym);
    }

    @Override
    @Transactional
    public void update(Gym gym) {
        gymUpdateUseCase.execute(gym);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        gymDeleteUseCase.execute(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Gym> findById(Integer id){
        return gymFindByIdUseCase.execute(id);
    }

    @Override
    @Transactional
    public List<Gym> findAll(){
        return gymFindAllUseCase.execute();
    }

}
