package com.x86.followup.module.user.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserException Tests")
class UserExceptionTest {

    @Test
    @DisplayName("Should have throwable behavior")
    void testThrowableException() {
        assertDoesNotThrow(() -> {
            throw new UserExistException("Test exception");
        });
    }

    @Test
    @DisplayName("Should create exception with message")
    void testExceptionWithMessage() {
        String message = "User already exists";
        UserExistException exception = new UserExistException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should create not found exception")
    void testUserNotFoundException() {
        String message = "User not found";
        UserNotFoundError exception = new UserNotFoundError(message);
        assertEquals(message, exception.getMessage());
    }
}
