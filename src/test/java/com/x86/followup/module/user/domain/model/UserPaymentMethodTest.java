package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserPaymentMethod Enum Tests")
class UserPaymentMethodTest {

    @Test
    @DisplayName("Should have EFECTIVO payment method")
    void testEfectivoMethod() {
        assertEquals(UserPaymentMethod.EFECTIVO, UserPaymentMethod.EFECTIVO);
    }

    @Test
    @DisplayName("Should have DIGITAL payment method")
    void testDigitalMethod() {
        assertEquals(UserPaymentMethod.DIGITAL, UserPaymentMethod.DIGITAL);
    }

    @Test
    @DisplayName("Should have all payment methods")
    void testAllMethods() {
        UserPaymentMethod[] methods = UserPaymentMethod.values();
        assertTrue(methods.length >= 2);
    }

    @Test
    @DisplayName("Should recognize different payment methods")
    void testDifferentMethods() {
        assertNotEquals(UserPaymentMethod.EFECTIVO, UserPaymentMethod.DIGITAL);
    }
}
