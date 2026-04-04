package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum UserRole {
    ADMIN("Administrador"),
    GYM("Gimnasio"),
    USER("Usuario");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public static UserRole fromValue(String text) {
        for (UserRole b : UserRole.values()) {
            if (b.value.equalsIgnoreCase(text) || b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Rol no reconocido: " + text);
    }
}
