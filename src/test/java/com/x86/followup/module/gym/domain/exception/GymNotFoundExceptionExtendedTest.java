package com.x86.followup.module.gym.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymNotFoundException Extended Tests")
class GymNotFoundExceptionExtendedTest {

    @Test
    @DisplayName("Should contain meaningful error message")
    void testExceptionMessage() {
        String message = "Gym with id 999 not found in the database";
        GymNotFoundException exception = new GymNotFoundException(message);
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    @DisplayName("Should be throwable")
    void testThrowException() {
        assertThrows(GymNotFoundException.class, () -> {
            throw new GymNotFoundException("Test exception");
        });
    }

    @Test
    @DisplayName("Should preserve exception details")
    void testExceptionDetails() {
        String detail = "Expected gym with id 123 but it does not exist";
        GymNotFoundException exception = new GymNotFoundException(detail);
        assertEquals(detail, exception.getMessage());
    }
}
