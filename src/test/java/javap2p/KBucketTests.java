package javap2p;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertSame;

class KBucketTests {

    @Test
    @DisplayName("A KBucket's contacts are always sorted by lastSeen in ASC order")
    void testKBucketHasSortedContacts() {
        var kbucket = new KBucket(0, 1, 1);

        // Last seen today
        var contactA = new Contact(Identifier.generateId());
        contactA.setLastSeen(new Date());

        // Last seen yesterday
        var contactB = new Contact(Identifier.generateId());
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        var yesterday = calendar.getTime();
        contactB.setLastSeen(yesterday);

        kbucket.add(contactA);
        kbucket.add(contactB);

        var contacts = kbucket.getContacts();
        var head = contacts.get(0);
        var tail = contacts.get(1);

        assertSame(head.getId(), contactB.getId());
        assertSame(tail.getId(), contactA.getId());
    }

}
