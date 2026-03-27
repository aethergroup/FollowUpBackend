package com.x86.followup.module.gym.infrastructure.mapper;

import com.x86.followup.module.gym.domain.model.*;
import com.x86.followup.module.gym.infrastructure.persistence.GymEntity;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {

    public GymEntity toEntity(Gym gym){
        if (gym == null) return null;

        GymEntity entity = new GymEntity();

        if (gym.getId() != null) {
            entity.setId(gym.getId().getValue());
        }

        entity.setName(gym.getName().getValue());
        entity.setEmail(gym.getEmail().getValue());
        entity.setPhone(gym.getPhone().getValue());
        entity.setAddress(gym.getAddress().getValue());
        entity.setPassword(gym.getPasswordHash().getValue());

        return entity;
    }

    public Gym toDomain(GymEntity entity){
        if (entity == null){
            return null;
        }

        return new Gym(
                new GymId(entity.getId()),
                new GymName(entity.getName()),
                new GymEmail(entity.getEmail()),
                new GymPhone(entity.getPhone()),
                new GymAddress(entity.getAddress()),
                new GymPasswordHash(entity.getPassword()),
                new GymCreatedAt(entity.getCreatedAt())
                );
    }
}
