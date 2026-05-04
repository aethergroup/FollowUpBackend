package com.x86.followup.module.subscription.domain.model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subscription {
    private SubscriptionId id;
    private final SubscriptionUserId userId;
    private final SubscriptionPlanId planId;
    private final SubscriptionStart start;
    private final SubscriptionEnd end;
    private final SubscriptionStatus status;

    public Subscription(SubscriptionId id,
                        SubscriptionUserId userId,
                        SubscriptionPlanId planId,
                        SubscriptionStart start,
                        SubscriptionEnd end,
                        SubscriptionStatus status) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId, "El userId es obligatorio");
        this.planId = Objects.requireNonNull(planId, "El planId es obligatorio");
        this.start = Objects.requireNonNull(start, "La fecha de inicio es obligatoria");
        this.end = Objects.requireNonNull(end, "La fecha de fin es obligatoria");
        this.status = Objects.requireNonNull(status, "El status es obligatorio");
    }

    public Subscription(SubscriptionUserId userId,
                        SubscriptionPlanId planId,
                        SubscriptionStart start,
                        SubscriptionEnd end,
                        SubscriptionStatus status) {
        this.userId = Objects.requireNonNull(userId, "El userId es obligatorio");
        this.planId = Objects.requireNonNull(planId, "El planId es obligatorio");
        this.start = Objects.requireNonNull(start, "La fecha de inicio es obligatoria");
        this.end = Objects.requireNonNull(end, "La fecha de fin es obligatoria");
        this.status = Objects.requireNonNull(status, "El status es obligatorio");
    }

    public void assignId(SubscriptionId id) {
        if (this.id != null) {
            throw new IllegalStateException("La suscripción ya tiene un ID asignado.");
        }
        this.id = Objects.requireNonNull(id, "El ID generado no puede ser nulo");
    }
}