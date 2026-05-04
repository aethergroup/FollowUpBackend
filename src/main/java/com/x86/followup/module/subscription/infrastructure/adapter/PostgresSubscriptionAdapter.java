package com.x86.followup.module.subscription.infrastructure.adapter;

import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.model.SubscriptionUserId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import com.x86.followup.module.subscription.infrastructure.mapper.SubscriptionMapper;
import com.x86.followup.module.subscription.infrastructure.persistence.JpaSubscriptionRepository;
import com.x86.followup.module.subscription.infrastructure.persistence.SubscriptionEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostgresSubscriptionAdapter implements SubscriptionRepository {

    private final JpaSubscriptionRepository jpaRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public Subscription save(Subscription subscription) {
        SubscriptionEntity entity = subscriptionMapper.toEntity(subscription);
        SubscriptionEntity savedEntity = jpaRepository.save(entity);
        return subscriptionMapper.toDomain(savedEntity);
    }

    @Override
    @Transactional
    public void update(Subscription subscription) {
        SubscriptionEntity existingEntity = jpaRepository.findById(subscription.getId().getValue())
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada para actualizar"));

        existingEntity.setUserId(subscription.getUserId().getValue());
        existingEntity.setPlanId(subscription.getPlanId().getValue());
        existingEntity.setStart(subscription.getStart().getValue());
        existingEntity.setEnd(subscription.getEnd().getValue());
        existingEntity.setStatus(subscription.getStatus());

        jpaRepository.save(existingEntity);
    }

    @Override
    public void delete(SubscriptionId id) {
        jpaRepository.deleteById(id.getValue());
    }

    @Override
    public Optional<Subscription> findById(SubscriptionId id) {
        return jpaRepository.findById(id.getValue())
                .map(subscriptionMapper::toDomain);
    }

    @Override
    public Optional<Subscription> findByUserId(SubscriptionUserId userId) {
        return jpaRepository.findByUserId(userId.getValue())
                .map(subscriptionMapper::toDomain);
    }

    @Override
    public List<Subscription> findAll() {
        return jpaRepository.findAll().stream()
                .map(subscriptionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
