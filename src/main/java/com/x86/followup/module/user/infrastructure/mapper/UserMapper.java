package com.x86.followup.module.user.infrastructure.mapper;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.infrastructure.persistence.IdentificationEntity;
import com.x86.followup.module.user.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();

        if (user.getId() != null) {
            entity.setId(user.getId().getValue());
        }

        entity.setGymId(user.getGymId().value());
        entity.setRole(user.getRole());
        entity.setName(user.getName().getValue());
        entity.setPhone(user.getPhone().getValue());
        entity.setPassword(user.getPassword().getValue());
        entity.setPaymentMethod(UserPaymentMethod.valueOf(user.getPaymentMethod().name()));

        if (user.getIdentification() != null) {
            IdentificationEntity idEntity = new IdentificationEntity();
            idEntity.setIdentification(user.getIdentification().getValue());
            idEntity.setIdentificationType(user.getIdentificationType().name());
            entity.setIdentification(idEntity);
        }

        return entity;
    }

    public User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                new UserId(entity.getId()),
                new UserGymId(entity.getGymId()),
                UserRole.valueOf(entity.getRole().name()),
                new UserName(entity.getName()),
                new UserIdentification(entity.getIdentification().getIdentification()),
                UserIdentificationType.valueOf(entity.getIdentification().getIdentificationType()),
                new UserPassword(entity.getPassword()),
                new UserPhone(entity.getPhone()),
                UserPaymentMethod.valueOf(String.valueOf(entity.getPaymentMethod())),
                new UserCreatedAt(entity.getCreatedAt())
        );
    }
}