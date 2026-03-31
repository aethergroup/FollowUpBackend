package com.x86.followup.module.user.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserNotFoundError Tests")
class UserNotFoundErrorTest {

    @Test
    @DisplayName("Should create UserNotFoundError with message")
    void testUserNotFoundErrorCreation() {
        String message = "User not found";
        UserNotFoundError exception = new UserNotFoundError(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should be instance of RuntimeException")
    void testIsRuntimeException() {
        UserNotFoundError exception = new UserNotFoundError("User not found");
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    @DisplayName("Should contain exception message")
    void testExceptionMessage() {
        String expectedMessage = "User with id 123 not found";
        UserNotFoundError exception = new UserNotFoundError(expectedMessage);

        assertTrue(exception.getMessage().contains("123"));
    }
}
