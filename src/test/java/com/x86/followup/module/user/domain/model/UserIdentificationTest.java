package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserIdentification Value Object Tests")
class UserIdentificationTest {

    @Test
    @DisplayName("Should create UserIdentification successfully")
    void testCreateUserIdentificationSuccess() {
        UserIdentification identification = new UserIdentification("12345678");
        assertNotNull(identification);
        assertEquals("12345678", identification.getValue());
    }

    @Test
    @DisplayName("Should fail when identification is null")
    void testUserIdentificationNull() {
        assertThrows(NullPointerException.class, () -> new UserIdentification(null));
    }

    @Test
    @DisplayName("Should store identification value")
    void testUserIdentificationValue() {
        UserIdentification identification = new UserIdentification("CC123456");
        assertTrue(identification.getValue().length() > 0);
    }
}
