package jtorrent;

/**
 * For the moment, this is the primary object of this package.
 */
class Node {

    private final String id;

    private final int kSize;

    private RoutingTable routingTable;

    // Files are stored on nodes with ids "close" to their keys via XOR
    private FileHashTable fileHashTable;

    Node() {
        this.id = Identifier.generateId();
        this.kSize = 20; // TODO
        this.fileHashTable = new FileHashTable(this.id);
        this.routingTable = new RoutingTable(this.kSize);
    }

    Node(String id, int KSize, FileHashTable fileHashTable, RoutingTable routingTable) {
        this.id = id;
        this.kSize = KSize;
        this.fileHashTable = fileHashTable;
        this.routingTable = routingTable;
    }

    String getId() {
        return this.id;
    }
}
