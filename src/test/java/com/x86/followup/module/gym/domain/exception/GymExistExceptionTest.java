package com.x86.followup.module.gym.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymExistException Tests")
class GymExistExceptionTest {

    @Test
    @DisplayName("Should create exception with message")
    void testExceptionCreation() {
        String message = "Gym already exists";
        GymExistException exception = new GymExistException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should be instance of RuntimeException")
    void testIsRuntimeException() {
        GymExistException exception = new GymExistException("Test");
        assertInstanceOf(RuntimeException.class, exception);
    }

    @Test
    @DisplayName("Should support exception message")
    void testExceptionMessage() {
        String message = "Gym with ID 1 already exists";
        GymExistException exception = new GymExistException(message);
        assertEquals(message, exception.getMessage());
    }
}
