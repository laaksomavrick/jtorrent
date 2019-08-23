package jtorrent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NodeTests {

    @Test
    @DisplayName("A node has a unique, 128 bit id")
    void testNodeIdExists() {
        Node node = new Node();
        var id = node.getId();
        assertNotNull(id);
    }

    @Test
    @DisplayName("A node can ping another node that exists")
    void testNodeCanPing() {
        var client = new InMemoryNetworkClient();
        client.seed();

        var firstId = client.getFirstNode().get().getId();

        Node node = new Node(client);

        var ping = node.sendPingRpc(firstId).get();

        assertNotNull(ping);
        assertEquals(ping, firstId);
    }
}
