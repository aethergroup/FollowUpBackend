package com.x86.followup.module.user.domain.model;

import com.x86.followup.module.user.domain.exception.UserIdNotValid;

import java.util.Objects;

public record UserGymId(Integer value) {
    public UserGymId {
        if (value == 0){
            throw new UserIdNotValid("El id no debe ser 0");
        } else {
            Objects.requireNonNull(value, "El gymId es obligatorio");
        }
    }
}
