package jtorrent;

// Each node has a unique id
// "We provide a lookup algorithm (b-tree) that locates successively "closer" nodes to any desired id
// ...converging to the lookup target in logarithmically many steps

// Effectively, nodes are leaves in a binary tree, with each node's position determined by the shortest
// unique prefix of it's id.

// e.g

// Node A: aa0000a
// Node B: bb0000a
// Node B: c0000a

// The routing table is a b-tree whose leaves are k-buckets
// Each k-bucket contains nodes/contacts with some common prefix of their ids
// This prefix is the k-bucket's position in the binary tree
// Thus, each k-bucket covers some range of the id space, and together the k-buckets cover the entire space

// TODO How do we determine the shortest unique prefix for a set of KBuckets?
// that is how compare in KBucket ought to be implemented
//

import java.util.TreeSet;

class RoutingTable {

    private TreeSet<KBucket> tree;

    private int kSize;

    RoutingTable(int kSize) {
        this.kSize = kSize;

        // TODO revisit how this is initialized
        this.tree = new TreeSet<>();
        KBucket initialBucket = new KBucket(0, 2 ^ 160, this.kSize);
        this.tree.add(initialBucket);
    }

    TreeSet<KBucket> getTree() {
        return tree;
    }


}
