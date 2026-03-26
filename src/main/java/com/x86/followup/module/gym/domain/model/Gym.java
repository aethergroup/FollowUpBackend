package com.x86.followup.module.gym.domain.model;

import java.util.Objects;

public class Gym {
    private GymId id;
    private final GymName name;
    private final GymEmail email;
    private final GymPhone phone;
    private final GymAddress address;
    private final GymPasswordHash passwordHash;
    private final GymCreatedAt createdAt;

    public Gym(GymId id,
               GymName name,
               GymEmail email,
               GymPhone phone,
               GymAddress address,
               GymPasswordHash passwordHash,
               GymCreatedAt createdAt) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.phone = Objects.requireNonNull(phone, "El telefono no puede ser nulo");
        this.address = Objects.requireNonNull(address, "La dirección no puede ser nula");
        this.passwordHash = Objects.requireNonNull(passwordHash, "La contraseña no puede ser nula");
        this.createdAt = createdAt;
    }
}
