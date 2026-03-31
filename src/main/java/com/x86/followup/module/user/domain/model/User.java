package com.x86.followup.module.user.domain.model;

import java.util.Objects;
import com.x86.followup.module.user.domain.exception.UserExistException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private UserId id;
    private final UserGymId gymId;
    private final UserName name;
    private final UserIdentification identification;
    private final UserIdentificationType identificationType;
    private UserPassword password;
    private final UserPhone phone;
    private final UserMembershipStart membershipStart;
    private final UserMembershipEnd membershipEnd;
    private final UserPaymentMethod paymentMethod;
    private final UserStatus status;
    private final UserCreatedAt createdAt;

    public User(UserId id,
                UserGymId gymId,
                UserName name,
                UserIdentification identification,
                UserIdentificationType identificationType,
                UserPassword password,
                UserPhone phone,
                UserMembershipStart membershipStart,
                UserMembershipEnd membershipEnd,
                UserPaymentMethod paymentMethod,
                UserStatus status,
                UserCreatedAt createdAt) {

        this.id = id;
        this.gymId = gymId;
        this.name = Objects.requireNonNull(name, "El nombre es obligatorio");
        this.identification = Objects.requireNonNull(identification, "La identificación es obligatoria");
        this.identificationType = Objects.requireNonNull(identificationType, "El tipo de identificación es obligatorio");
        this.password = Objects.requireNonNull(password, "La contraseña no puede estar vacia o nula");
        this.phone = Objects.requireNonNull(phone, "El teléfono es obligatorio");
        this.membershipStart = Objects.requireNonNull(membershipStart, "La fecha de inicio es obligatoria");
        this.membershipEnd = Objects.requireNonNull(membershipEnd, "La fecha de fin es obligatoria");

        if (membershipEnd.getValue().before(membershipStart.getValue())) {
            throw new IllegalArgumentException("La fecha de fin de membresía no puede ser anterior a la de inicio");
        }

        this.paymentMethod = Objects.requireNonNull(paymentMethod, "El método de pago es obligatorio");
        this.status = Objects.requireNonNull(status, "El estado es obligatorio");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación es obligatoria");
    }

    public void assignId(UserId id) {
        if (this.id != null) {
            throw new UserExistException("El usuario ya tiene un ID asignado.");
        }
        this.id = Objects.requireNonNull(id, "El ID generado no puede ser nulo");
    }

    public boolean isSubscriptionActive() {
        return UserStatus.ACTIVE.equals(status);
    }
}