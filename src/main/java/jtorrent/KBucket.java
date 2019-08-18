package jtorrent;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A Kbucket wraps a list of nodes with a common prefix for their id,
 * sorted by the last time they were seen. This prefix is the k-bucket's position
 * in the routing table (binary tree).
 */
class KBucket implements Comparable<KBucket> {

    /**
     * The lower prefix range for this bucket.
     */
    private int rangeLower;

    /**
     * The upper prefix range for this bucket.
     */
    private int rangeUpper;

    /**
     * The maximum allowed number of items for this bucket.
     */
    private int kSize;

    private ArrayList<Contact> contacts = new ArrayList<>();

    KBucket(int rangeLower, int rangeUpper, int kSize) {
       this.rangeLower = rangeLower;
       this.rangeUpper = rangeUpper;
       this.kSize = kSize;
    }

    ArrayList<Contact> getContacts() {
        return contacts;
    }

    // Each k-bucket is sorted by time last seen
    // Least recently seen node at the head, most recently seen at the tail.
    void add(Contact contact) {
        // TODO: account for KSize
        // TODO: handle when contacts > ksize (need to split), routingTable can do that for us
        this.contacts.add(contact);
        this.contacts.sort(Comparator.comparing(Contact::getLastSeen));
    }

    int getRangeLower() {
        return rangeLower;
    }

    int getRangeUpper() {
        return rangeUpper;
    }

    public int getkSize() {
        return kSize;
    }

    @Override
    public int compareTo(KBucket k) {
        return this.getRangeLower() - k.getRangeLower();
    }
}
