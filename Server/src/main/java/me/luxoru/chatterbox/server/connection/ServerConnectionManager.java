package me.luxoru.chatterbox.server.connection;

import lombok.AllArgsConstructor;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.chatterbox.server.client.User;
import me.luxoru.chatterbox.server.client.UserManager;

import java.net.InetSocketAddress;
@AllArgsConstructor
public class ServerConnectionManager {

    private final UserManager userManager;

    public boolean handleConnection(ServerBoundConnectionPacket packet, InetSocketAddress sockerAddr){

        String hostAddress = packet.getHostAddress();
        User user = new User()

    }

}
