package javap2p;

import java.util.Hashtable;
import java.util.Optional;

public class FileHashTable {

    private final Hashtable<String, String> hashTable;

    FileHashTable() {
        this.hashTable = new Hashtable<String, String>();
    }

    public void set(String fileId, String fileUrl) {
       this.hashTable.put(fileId, fileUrl);
    }

    public Optional<String> get(String fileId) {
        Optional<String> maybeFileUrl = Optional.ofNullable(this.hashTable.get(fileId));
        return maybeFileUrl;
    }
}
