package jtorrent;

import java.util.Optional;

public interface NetworkClient {
    Optional<String> ping(String id);
}
