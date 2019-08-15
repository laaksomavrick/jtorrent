package javap2p;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Node node = new Node();
        UUID id = node.getUuid();
        System.out.println(id.toString());
    }
}
