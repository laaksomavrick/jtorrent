package jtorrent;

import java.util.Date;
import java.util.Optional;

/**
 * Data class for registering contact information for other nodes in the network.
 * IP and Port are optional values, being set when the node exists over a network.
 */
class Contact {

    private final String id;

    private final Optional<String> ip;

    private final Optional<Number> port;

    private Date lastSeen;

    Contact(String id, String ip, Number port) {
        this.id = id;
        this.ip = Optional.of(ip);
        this.port = Optional.of(port);
    }

    Contact(String id) {
        this.id = id;
        this.ip = Optional.empty();
        this.port = Optional.empty();
    }

    String getId() {
        return id;
    }

    public Optional<String> getIp() {
        return ip;
    }

    public Optional<Number> getPort() {
        return port;
    }

    Date getLastSeen() {
        return lastSeen;
    }

    void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }
}
