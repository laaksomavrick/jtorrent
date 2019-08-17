package javap2p;

import java.util.Hashtable;
import java.util.Optional;
import java.util.UUID;

class FileHashTable {

    private final UUID nodeId;
    private final Hashtable<String, String> hashTable;

    FileHashTable(UUID nodeId) {
        this.nodeId = nodeId;
        this.hashTable = new Hashtable<>();
    }

    void set(String fileId, String fileUrl) {
       this.hashTable.put(fileId, fileUrl);
    }

    Optional<String> get(String fileId) {
        Optional<String> maybeFileUrl = Optional.ofNullable(this.hashTable.get(fileId));
        return maybeFileUrl;
    }
}
