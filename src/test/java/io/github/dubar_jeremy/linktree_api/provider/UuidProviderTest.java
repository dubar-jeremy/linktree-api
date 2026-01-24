package io.github.dubar_jeremy.linktree_api.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UuidProviderTest {

    private final UuidProvider uuidProvider = new UuidProvider();

    @Test
    @DisplayName("UuidProvider should generate valid UUIDs")
    void shouldGenerateValidUUIDs() {
        // Act
        UUID result = uuidProvider.generate();

        // Assert
        assertNotNull(result, "UUID should not be null");
        assertEquals(4, result.version(), "UUID version should be 4 (randomly generated UUID)");
    }

    @Test
    @DisplayName("UuidProvider should generate unique UUIDs")
    void shouldGenerateUniqueUUIDs() {
        // Arrange
        Set<UUID> uuids = new HashSet<>();
        int numberOfUUIDs = 1000;

        // Act
        for (int i = 0; i < numberOfUUIDs; i++) {
            uuids.add(uuidProvider.generate());
        }

        // Assert
        assertEquals(numberOfUUIDs, uuids.size(), "All generated UUIDs should be unique");
    }
}
