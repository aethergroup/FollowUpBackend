package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class SubscriptionFindAllUseCase {

    private final SubscriptionRepository repository;

    public List<Subscription> execute() {
        List<Subscription> subscriptions = repository.findAll();
        return Collections.unmodifiableList(subscriptions);
    }
}