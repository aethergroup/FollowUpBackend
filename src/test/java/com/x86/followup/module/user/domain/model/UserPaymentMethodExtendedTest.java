package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserPaymentMethod Enum Tests")
class UserPaymentMethodExtendedTest {

    @Test
    @DisplayName("Should have DIGITAL payment method")
    void testDigitalPaymentMethod() {
        UserPaymentMethod method = UserPaymentMethod.DIGITAL;
        assertNotNull(method);
    }

    @Test
    @DisplayName("Should have EFECTIVO payment method")
    void testEfectivoPaymentMethod() {
        UserPaymentMethod method = UserPaymentMethod.EFECTIVO;
        assertNotNull(method);
    }

    @Test
    @DisplayName("Should retrieve all payment methods")
    void testAllPaymentMethods() {
        UserPaymentMethod[] methods = UserPaymentMethod.values();
        assertTrue(methods.length >= 2);
    }

    @Test
    @DisplayName("Should handle different payment methods")
    void testDifferentPaymentMethods() {
        UserPaymentMethod m1 = UserPaymentMethod.DIGITAL;
        UserPaymentMethod m2 = UserPaymentMethod.EFECTIVO;
        assertNotEquals(m1, m2);
    }
}
