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

        entity.setName(user.getName().getValue());
        entity.setPhone(user.getPhone().getValue());
        entity.setPaymentMethod(UserPaymentMethod.valueOf(user.getPaymentMethod().name()));
        entity.setStatus(UserStatus.valueOf(user.getStatus().name()));
        entity.setMembershipStart(user.getMembershipStart().getValue());
        entity.setMembershipEnd(user.getMembershipEnd().getValue());

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
                new UserName(entity.getName()),
                new UserIdentification(entity.getIdentification().getIdentification()),
                UserIdentificationType.valueOf(entity.getIdentification().getIdentificationType()),
                new UserPhone(entity.getPhone()),
                new UserMembershipStart(entity.getMembershipStart()),
                new UserMembershipEnd(entity.getMembershipEnd()),
                UserPaymentMethod.valueOf(String.valueOf(entity.getPaymentMethod())),
                UserStatus.valueOf(String.valueOf(entity.getStatus())),
                new UserCreatedAt(entity.getCreatedAt())
        );
    }
}