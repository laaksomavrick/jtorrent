package javap2p;

import java.util.UUID;

class Node {

    private final UUID uuid;

    // RoutingTable
        // "Buckets", each containing contact info for nodes of a particular distance
            // Contact, each containing ID, IP and PORT of a node

    // FileHashTable, mapping file ids to file locations

    Node() {
        this.uuid = UUID.randomUUID();
    }

    UUID getUuid() {
        return uuid;
    }
}
