package javap2p;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

/**
 * A Kbucket wraps a list of nodes with a common prefix for their id,
 * sorted by the last time they were seen. This prefix is the k-bucket's position
 * in the routing table (binary tree).
 */
class KBucket {

    private Number rangeLower;

    private Number rangeUpper;

    private Number KSize;

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    KBucket(Number rangeLower, Number rangeUpper, Number KSize) {
       this.rangeLower = rangeLower;
       this.rangeUpper = rangeUpper;
       this.KSize = KSize;
    }

    ArrayList<Contact> getContacts() {
        return contacts;
    }

    Boolean inRange(UUID uuid) {
        return true;
    }

    // Each k-bucket is sorted by time last seen
    // Least recently seen node at the head, most recently seen at the tail.
    void add(Contact contact) {
        this.contacts.add(contact);
        this.contacts.sort(Comparator.comparing(Contact::getLastSeen));
    }
}
