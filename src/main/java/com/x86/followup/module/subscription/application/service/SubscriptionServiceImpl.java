package com.x86.followup.module.subscription.application.service;

import com.x86.followup.module.subscription.application.usecase.*;
import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.model.SubscriptionUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionSaveUseCase subscriptionSaveUseCase;
    private final SubscriptionUpdateUseCase subscriptionUpdateUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;
    private final SubscriptionFindAllUseCase subscriptionFindAllUseCase;
    private final SubscriptionFindByIdUseCase subscriptionFindByIdUseCase;
    private final SubscriptionFindByUserIdUseCase subscriptionFindByUserIdUseCase;

    @Override
    @Transactional
    public void save(Subscription subscription) {
        subscriptionSaveUseCase.execute(subscription);
    }

    @Override
    @Transactional
    public void update(Subscription subscription) {
        subscriptionUpdateUseCase.execute(subscription);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        subscriptionDeleteUseCase.execute(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subscription> findAll() {
        return subscriptionFindAllUseCase.execute();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subscription> findById(Integer id) {
        return subscriptionFindByIdUseCase.execute(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subscription> findByUserId(Integer userId) {
        return subscriptionFindByUserIdUseCase.execute(userId);
    }
}