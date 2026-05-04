package com.x86.followup.module.subscription.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SubscriptionStatus {
    ACTIVE("ACTIVO"),
    IN_PENDING("PENDIENTE"),
    INACTIVE("INACTIVO");

    private final String value;
}