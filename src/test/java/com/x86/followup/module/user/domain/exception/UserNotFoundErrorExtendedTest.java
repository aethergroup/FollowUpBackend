package com.x86.followup.module.user.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserNotFoundError Extended Tests")
class UserNotFoundErrorExtendedTest {

    @Test
    @DisplayName("Should contain meaningful error message")
    void testExceptionMessage() {
        String message = "User with identification 99999999 not found";
        UserNotFoundError exception = new UserNotFoundError(message);
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    @DisplayName("Should be throwable")
    void testThrowException() {
        assertThrows(UserNotFoundError.class, () -> {
            throw new UserNotFoundError("Test exception");
        });
    }

    @Test
    @DisplayName("Should preserve exception details")
    void testExceptionDetails() {
        String detail = "Expected user but it does not exist";
        UserNotFoundError exception = new UserNotFoundError(detail);
        assertEquals(detail, exception.getMessage());
    }
}
