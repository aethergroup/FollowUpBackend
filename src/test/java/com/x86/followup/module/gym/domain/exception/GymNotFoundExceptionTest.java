package com.x86.followup.module.gym.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymNotFoundException Tests")
class GymNotFoundExceptionTest {

    @Test
    @DisplayName("Should create exception with message")
    void testExceptionCreation() {
        String message = "Gym not found";
        GymNotFoundException exception = new GymNotFoundException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should be instance of RuntimeException")
    void testIsRuntimeException() {
        GymNotFoundException exception = new GymNotFoundException("Test");
        assertInstanceOf(RuntimeException.class, exception);
    }

    @Test
    @DisplayName("Should support exception message")
    void testExceptionMessage() {
        String message = "Gym with ID 999 not found";
        GymNotFoundException exception = new GymNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }
}
