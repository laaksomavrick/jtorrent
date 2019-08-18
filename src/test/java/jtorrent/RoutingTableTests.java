package jtorrent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoutingTableTests {

    @Test
    @DisplayName("A RoutingTable initializes a tree when constructed")
    void testRoutingTreeInitializesATreeWhenConstructed() {
        var routingTable = new RoutingTable(20);
        var tree = routingTable.getTree();

        assertEquals(1, tree.size());

        var head = tree.first();

        assertEquals(0, head.getRangeLower());
        assertEquals(2 ^ 160, head.getRangeUpper());
    }
}
