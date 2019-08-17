package javap2p;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NodeTests {

    @Test
    @DisplayName("A node has a unique, 128 bit id")
    void testNodeIdExists() {
        Node node = new Node();
        var id = node.getId();
        assertNotNull(id);
    }
}
