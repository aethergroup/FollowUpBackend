package com.x86.followup.module.user.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserExistException Extended Tests")
class UserExistExceptionExtendedTest {

    @Test
    @DisplayName("Should contain meaningful error message")
    void testExceptionMessage() {
        String message = "User with identification 12345678 already exists";
        UserExistException exception = new UserExistException(message);
        assertTrue(exception.getMessage().contains("already exists"));
    }

    @Test
    @DisplayName("Should be throwable")
    void testThrowException() {
        assertThrows(UserExistException.class, () -> {
            throw new UserExistException("Test exception");
        });
    }

    @Test
    @DisplayName("Should preserve stack trace")
    void testStackTrace() {
        UserExistException exception = new UserExistException("Stack trace test");
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }
}
