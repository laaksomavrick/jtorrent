package jtorrent;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        var client = new InMemoryNetworkClient();
        client.seed();
        var first = client.getFirstNode().get();

        Node node = new Node(client);

        var ping = node.sendPingRpc(first.getId());
        System.out.println(ping);
    }
}
