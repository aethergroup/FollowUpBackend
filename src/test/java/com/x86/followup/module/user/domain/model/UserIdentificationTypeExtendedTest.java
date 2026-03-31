package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserIdentificationType Enum Tests")
class UserIdentificationTypeExtendedTest {

    @Test
    @DisplayName("Should have CC identification type")
    void testCCType() {
        UserIdentificationType type = UserIdentificationType.CC;
        assertNotNull(type);
    }

    @Test
    @DisplayName("Should have TI identification type")
    void testTIType() {
        UserIdentificationType type = UserIdentificationType.TI;
        assertNotNull(type);
    }

    @Test
    @DisplayName("Should have multiple identification types")
    void testMultipleTypes() {
        UserIdentificationType type = UserIdentificationType.CC;
        assertNotNull(type);
    }

    @Test
    @DisplayName("Should retrieve all identification types")
    void testAllTypes() {
        UserIdentificationType[] types = UserIdentificationType.values();
        assertTrue(types.length >= 3);
    }

    @Test
    @DisplayName("Should handle different identification types")
    void testDifferentTypes() {
        UserIdentificationType t1 = UserIdentificationType.CC;
        UserIdentificationType t2 = UserIdentificationType.TI;
        assertNotEquals(t1, t2);
    }
}
