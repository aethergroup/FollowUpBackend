package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserIdentificationType Enum Tests")
class UserIdentificationTypeTest {

    @Test
    @DisplayName("Should have CC identification type")
    void testCCType() {
        assertEquals(UserIdentificationType.CC, UserIdentificationType.CC);
    }

    @Test
    @DisplayName("Should have TI identification type")
    void testTIType() {
        assertEquals(UserIdentificationType.TI, UserIdentificationType.TI);
    }

    @Test
    @DisplayName("Should have CE identification type")
    void testCEType() {
        assertEquals(UserIdentificationType.CE, UserIdentificationType.CE);
    }

    @Test
    @DisplayName("Should have PP identification type")
    void testPPType() {
        assertEquals(UserIdentificationType.PP, UserIdentificationType.PP);
    }

    @Test
    @DisplayName("Should have all identification types")
    void testAllTypes() {
        UserIdentificationType[] types = UserIdentificationType.values();
        assertTrue(types.length >= 4);
    }
}
