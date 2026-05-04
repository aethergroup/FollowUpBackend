package com.x86.followup.module.subscription.infrastructure.mapper;

import com.x86.followup.module.subscription.domain.model.*;
import com.x86.followup.module.subscription.infrastructure.persistence.SubscriptionEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SubscriptionMapper {

    public SubscriptionEntity toEntity(Subscription subscription) {
        if (subscription == null) {
            return null;
        }

        SubscriptionEntity entity = new SubscriptionEntity();

        if (subscription.getId() != null) {
            entity.setId(subscription.getId().getValue());
        }

        entity.setUserId(subscription.getUserId().getValue());
        entity.setPlanId(subscription.getPlanId().getValue());
        entity.setStart(subscription.getStart().getValue());
        entity.setEnd(subscription.getEnd().getValue());
        entity.setStatus(subscription.getStatus());

        return entity;
    }

    public Subscription toDomain(SubscriptionEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Subscription(
                new SubscriptionId(entity.getId()),
                new SubscriptionUserId(entity.getUserId()),
                new SubscriptionPlanId(entity.getPlanId()),
                new SubscriptionStart(entity.getStart()),
                new SubscriptionEnd(entity.getEnd()),
                entity.getStatus()
        );
    }
}
