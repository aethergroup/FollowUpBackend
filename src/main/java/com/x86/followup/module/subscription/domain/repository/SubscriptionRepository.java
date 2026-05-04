package com.x86.followup.module.subscription.domain.repository;

import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.model.SubscriptionUserId;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);
    void update(Subscription subscription);
    void delete(SubscriptionId id);

    Optional<Subscription> findById(SubscriptionId id);
    Optional<Subscription> findByUserId(SubscriptionUserId userId);
    List<Subscription> findAll();
}