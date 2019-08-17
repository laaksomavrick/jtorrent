package javap2p;

import java.util.UUID;

class Node {

    private final UUID uuid;

    // RoutingTable
        // "Buckets", each containing contact info for nodes of a particular distance
            // Contact, each containing ID, IP and PORT of a node

    // FileHashTable, mapping file ids to file locations
        // Files are stored on nodes with ids "close" to their keys via XOR

    private final FileHashTable fileHashTable;

    Node() {
        this.uuid = Node.generateId();
        this.fileHashTable = new FileHashTable(this.uuid);
    }

    Node(UUID uuid, FileHashTable fileHashTable) {
        this.uuid = uuid;
        this.fileHashTable = fileHashTable;
    }

    static UUID generateId() {
        return UUID.randomUUID();
    }

    UUID getUuid() {
        return uuid;
    }
}
