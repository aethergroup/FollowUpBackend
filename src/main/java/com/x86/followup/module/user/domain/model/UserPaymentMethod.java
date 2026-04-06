package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserPaymentMethod {
    EFECTIVO("Pagar en efectivo"),
    DIGITAL("Pagar Digitalmente");

    private final String value;

}
