package javap2p;

import java.util.UUID;

class Node {

    private final UUID uuid;

    Node() {
        this.uuid = UUID.randomUUID();
    }

    UUID getUuid() {
        return uuid;
    }
}
