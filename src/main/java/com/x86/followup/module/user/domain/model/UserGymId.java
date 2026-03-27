package com.x86.followup.module.user.domain.model;

import java.util.Objects;

public record UserGymId(Integer value) {
    public UserGymId {
        Objects.requireNonNull(value, "El gymId es obligatorio");
    }
}
