package javap2p;

import java.util.Hashtable;
import java.util.Optional;

class FileHashTable {

    private final String nodeId;
    private final Hashtable<String, String> hashTable;

    FileHashTable(String nodeId) {
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
