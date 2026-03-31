package com.x86.followup.module.gym.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymException Tests")
class GymExceptionTest {

    @Test
    @DisplayName("Should have throwable behavior")
    void testThrowableException() {
        assertDoesNotThrow(() -> {
            throw new GymExistException("Test exception");
        });
    }

    @Test
    @DisplayName("Should create exception with message")
    void testExceptionWithMessage() {
        String message = "Gym already exists";
        GymExistException exception = new GymExistException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should create not found exception")
    void testGymNotFoundException() {
        String message = "Gym not found";
        GymNotFoundException exception = new GymNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }
}
