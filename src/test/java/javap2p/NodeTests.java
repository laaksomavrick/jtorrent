package javap2p;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTests {

    @Test
    @DisplayName("A node has a unique, 128 bit id")
    void testNodeIdExists() {
        Node node = new Node();
        UUID uuid = node.getUuid();
        assertNotNull(uuid);
    }
}
