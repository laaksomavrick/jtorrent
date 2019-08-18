package javap2p;

class Node {

    private static final String GENERATE_ID_ALGORITHM = "SHA-256";
    private static final String STRING_ENCODING = "UTF-8";

    private final String id;

    // RoutingTable
        // "Buckets", each containing contact info for nodes of a particular distance
            // Contact, each containing ID, IP and PORT of a node

    // FileHashTable, mapping file ids to file locations
        // Files are stored on nodes with ids "close" to their keys via XOR

    private final FileHashTable fileHashTable;

    Node() {
        this.id = Identifier.generateId();
        this.fileHashTable = new FileHashTable(this.id);
    }

    Node(String id, FileHashTable fileHashTable) {
        this.id = id;
        this.fileHashTable = fileHashTable;
    }

    String getId() {
        return this.id;
    }
}
