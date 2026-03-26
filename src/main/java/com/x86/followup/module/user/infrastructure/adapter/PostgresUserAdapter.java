package com.x86.followup.module.user.infrastructure.adapter;

import com.x86.followup.module.user.domain.exception.UserNotFoundError;
import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserId;
import com.x86.followup.module.user.domain.model.UserIdentification;
import com.x86.followup.module.user.domain.repository.UserRepository;
import com.x86.followup.module.user.infrastructure.mapper.UserMapper;
import com.x86.followup.module.user.infrastructure.persistence.JpaUserRepository;
import com.x86.followup.module.user.infrastructure.persistence.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostgresUserAdapter implements UserRepository {

    private final JpaUserRepository jpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        if (entity.getIdentification() != null) {
            entity.getIdentification().setUser(entity);
        }

        UserEntity savedEntity = jpaRepository.save(entity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    @Transactional
    public void update(User user) {
        UserEntity existingEntity = jpaRepository.findById(user.getId().getValue())
                .orElseThrow(() -> new UserNotFoundError("Usuario no encontrado para actualizar"));

        existingEntity.setName(user.getName().getValue());
        existingEntity.setPhone(user.getPhone().getValue());
        existingEntity.setPaymentMethod(user.getPaymentMethod());
        existingEntity.setStatus(user.getStatus());
        existingEntity.setMembershipEnd(user.getMembershipEnd().getValue());

        if (existingEntity.getIdentification() != null && user.getIdentification() != null) {
            existingEntity.getIdentification().setIdentification(user.getIdentification().getValue());
            existingEntity.getIdentification().setIdentificationType(user.getIdentificationType().name());
        }

        jpaRepository.save(existingEntity);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return jpaRepository.findById(id.getValue())
                .map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByIdentification(UserIdentification identification) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByIdentification(String identification) {
        return jpaRepository.findByIdentification_Identification(identification)
                .map(userMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UserId id) {
        jpaRepository.deleteById(id.getValue());
    }
}