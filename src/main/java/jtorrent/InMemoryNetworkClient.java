package jtorrent;

import java.util.ArrayList;
import java.util.Optional;

/**
 * InMemoryNetworkClient provides an implementation of a NetworkClient
 * where all data about the network is stored in memory, ie, the network
 * only exists locally in a single process.
 *
 * This class is useful for local development and testing as a consequence.
 */
public class InMemoryNetworkClient implements NetworkClient {

    private ArrayList<Node> nodes;

    InMemoryNetworkClient() {
        this.nodes = new ArrayList<>();
    }

    public Optional<String> ping(String id) {
        var node = this.nodes.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElse(null);
        if (node != null) {
           return Optional.of(node.receivePingRpc());
        } else {
           return Optional.empty();
        }
    }

    public void seed() {
        for (int i = 0; i < 10; i++) {
            var node = new Node();
            this.nodes.add(node);
        }
    }

    public Optional<Node> getFirstNode() {
        return this.nodes.stream().findFirst();
    }
}
