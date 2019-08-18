package javap2p;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileHashTableTests {

    @Test
    @DisplayName("A FileHashTable can set and get a key-value pair")
    void testNodeIdExists() {
        var fileHashTable = new FileHashTable(Identifier.generateId());

        fileHashTable.set("foo", "value");

        var shouldExist = fileHashTable.get("foo");
        var shouldntExist = fileHashTable.get("bar");

        assertTrue(shouldExist.isPresent());
        assertEquals(shouldExist.get(), "value");

        assertTrue(shouldntExist.isEmpty());
    }
}
