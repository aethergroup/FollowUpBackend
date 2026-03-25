package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserIdentificationType {
    CC("Cédula de Ciudadania"),
    TI("Tarjeta de Identidad"),
    CE("Cédula de Extranjeria"),
    PP("Pasaporte");

    private final String value;
}
