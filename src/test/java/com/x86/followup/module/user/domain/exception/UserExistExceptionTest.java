package com.x86.followup.module.user.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserExistException Tests")
class UserExistExceptionTest {

    @Test
    @DisplayName("Should create UserExistException with message")
    void testUserExistExceptionCreation() {
        String message = "User already exists";
        UserExistException exception = new UserExistException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should be instance of RuntimeException")
    void testIsRuntimeException() {
        UserExistException exception = new UserExistException("User exists");
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    @DisplayName("Should contain exception message")
    void testExceptionMessage() {
        String expectedMessage = "User with id 1 already exists";
        UserExistException exception = new UserExistException(expectedMessage);

        assertTrue(exception.getMessage().contains("id"));
    }
}
