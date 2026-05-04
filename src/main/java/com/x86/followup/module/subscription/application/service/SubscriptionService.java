package com.x86.followup.module.subscription.application.service;

import com.x86.followup.module.subscription.domain.model.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    void save(Subscription subscription);

    void update(Subscription subscription);

    void delete(Integer id);

    List<Subscription> findAll();

    Optional<Subscription> findById(Integer id);

    Optional<Subscription> findByUserId(Integer userId);
}