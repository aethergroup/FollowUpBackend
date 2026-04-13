package com.x86.followup.module.plan.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PlanIsActive {
    ACTIVE("Plan Activo"),
    INACTIVE("Plan Inactivo");

    private final String value;
}
