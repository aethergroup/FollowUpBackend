package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SubscriptionFindByIdUseCase {

    private final SubscriptionRepository repository;

    public Optional<Subscription> execute(Integer id) {
        if (id == null || id <= 0) {
            return Optional.empty();
        }
        return repository.findById(new SubscriptionId(id));
    }
}