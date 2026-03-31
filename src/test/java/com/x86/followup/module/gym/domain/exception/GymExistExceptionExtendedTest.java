package com.x86.followup.module.gym.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymExistException Extended Tests")
class GymExistExceptionExtendedTest {

    @Test
    @DisplayName("Should contain meaningful error message")
    void testExceptionMessage() {
        String message = "Gym with name 'PowerFit Pro' already exists in the system";
        GymExistException exception = new GymExistException(message);
        assertTrue(exception.getMessage().contains("already exists"));
    }

    @Test
    @DisplayName("Should be throwable")
    void testThrowException() {
        assertThrows(GymExistException.class, () -> {
            throw new GymExistException("Test exception");
        });
    }

    @Test
    @DisplayName("Should preserve stack trace")
    void testStackTrace() {
        GymExistException exception = new GymExistException("Stack trace test");
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }
}
