package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionUserId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SubscriptionFindByUserIdUseCase {

    private final SubscriptionRepository repository;

    public Optional<Subscription> execute(Integer userId) {
        if (userId == null || userId <= 0) {
            return Optional.empty();
        }
        return repository.findByUserId(new SubscriptionUserId(userId));
    }
}