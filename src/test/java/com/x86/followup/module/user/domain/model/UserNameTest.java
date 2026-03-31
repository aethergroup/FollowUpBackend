package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserName Value Object Tests")
class UserNameTest {

    @Test
    @DisplayName("Should create UserName successfully")
    void testCreateUserNameSuccess() {
        UserName name = new UserName("John Doe");
        assertNotNull(name);
        assertEquals("John Doe", name.getValue());
    }

    @Test
    @DisplayName("Should fail when name is null")
    void testUserNameNull() {
        assertThrows(NullPointerException.class, () -> new UserName(null));
    }

    @Test
    @DisplayName("Should handle name with special characters")
    void testUserNameSpecialChars() {
        UserName name = new UserName("João da Silva");
        assertEquals("João da Silva", name.getValue());
    }
}
