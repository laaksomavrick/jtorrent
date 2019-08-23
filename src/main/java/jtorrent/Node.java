package jtorrent;

import java.util.Optional;

/**
 * For the moment, this is the primary object of this package.
 */
class Node {

    private final String id;

    private final int kSize;

    private RoutingTable routingTable;

    // Files are stored on nodes with ids "close" to their keys via XOR
    private FileHashTable fileHashTable;

    private NetworkClient networkClient;

    Node() {
        this.id = Identifier.generateId();
        this.kSize = 20; // TODO
        this.fileHashTable = new FileHashTable(this.id);
        this.routingTable = new RoutingTable(this.kSize);
        this.networkClient = new InMemoryNetworkClient();
    }

    Node(NetworkClient networkClient) {
        this.id = Identifier.generateId();
        this.kSize = 20; // TODO
        this.fileHashTable = new FileHashTable(this.id);
        this.routingTable = new RoutingTable(this.kSize);
        this.networkClient = networkClient;
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

    /**
     * Probe a node to see whether or not it is online
     * @param id
     * @return
     */
    Optional<String> sendPingRpc(String id) {
         return this.networkClient.ping(id);
    }

    String receivePingRpc() {
       return this.getId();
    }



    // Store
    // Instruct a node to store a (k, v) pair for later retrieval

    // FindNode
    // Returns a Contact for each K-node this node knows about closest to the given id
    // These triples can come from a single k-bucket, or they may come from multiple k-buckets if the closest is not full
    // Must return k items (unless there are fewer than k nodes in all its k-buckets, in which case return every node known)

    // FindValue
    // Behaves like find node, returning a Contact forea, except:
    // if the recipient has received a store rpc for the key, it just returns the stored value

}
