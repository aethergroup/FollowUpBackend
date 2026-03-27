package com.x86.followup.module.gym.infrastructure.adapter;

import com.x86.followup.module.gym.domain.exception.GymNotFoundException;
import com.x86.followup.module.gym.domain.model.Gym;
import com.x86.followup.module.gym.domain.model.GymId;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import com.x86.followup.module.gym.infrastructure.mapper.GymMapper;
import com.x86.followup.module.gym.infrastructure.persistence.GymEntity;
import com.x86.followup.module.gym.infrastructure.persistence.JpaGymRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostgresGymAdapter implements GymRepository {

    private final JpaGymRepository jpaGymRepository;
    private final GymMapper gymMapper;

    @Override
    public Gym save(Gym gym){
        GymEntity entity = gymMapper.toEntity(gym);

        GymEntity savedEntity = jpaGymRepository.save(entity);

        return gymMapper.toDomain(savedEntity);

    }

    @Override
    @Transactional
    public void update(Gym gym){

        GymEntity existingEntity = jpaGymRepository.findById(gym.getId().getValue())
                .orElseThrow(() -> new GymNotFoundException("Gym no encontrado para actualizar"));

        existingEntity.setName(gym.getName().getValue());
        existingEntity.setEmail(gym.getEmail().getValue());
        existingEntity.setPhone(gym.getPhone().getValue());
        existingEntity.setAddress(gym.getAddress().getValue());
        existingEntity.setPassword(gym.getPasswordHash().getValue());

        jpaGymRepository.save(existingEntity);
    }

    @Override
    public void delete(GymId id){
        jpaGymRepository.deleteById(id.getValue());
    }

    @Override
    public Optional<Gym> findById(GymId id){
        return jpaGymRepository.findById(id.getValue())
                .map(gymMapper::toDomain);
    }

    @Override
    public List<Gym> findAll(){
        return jpaGymRepository.findAll()
                .stream()
                .map(gymMapper::toDomain)
                .collect(Collectors.toList());
    }
}
