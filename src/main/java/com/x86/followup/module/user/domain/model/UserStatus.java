package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserStatus {
    ACTIVE("Usuario activo"),
    IN_PENDING("Usuario pendiente por pagar"),
    INACTIVE("Usuario inactivo");

    private final String value;
}
