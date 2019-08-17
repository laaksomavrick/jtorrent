package javap2p;

import java.security.MessageDigest;
import java.util.UUID;

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
        this.id = Node.generateId();
        this.fileHashTable = new FileHashTable(this.id);
    }

    Node(String id, FileHashTable fileHashTable) {
        this.id = id;
        this.fileHashTable = fileHashTable;
    }

    // TODO: refactor out
    static String generateId() {
        try {
            var uuid = UUID.randomUUID();
            var salt = MessageDigest.getInstance(GENERATE_ID_ALGORITHM);
            salt.update(uuid.toString().getBytes(STRING_ENCODING));
            var digest = salt.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }

    }

    String getId() {
        return this.id;
    }
}
