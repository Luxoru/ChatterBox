package me.luxoru.chatterbox.server.connection;

import lombok.AllArgsConstructor;
import me.luxoru.chatterbox.commons.packet.client.ClientBoundConnectionAckPacket;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.chatterbox.server.client.User;
import me.luxoru.chatterbox.server.client.UserManager;
import me.luxoru.chatterbox.server.packet.ServerPacketManager;
import me.luxoru.netsync.commons.PacketSendable;

import java.net.InetSocketAddress;
@AllArgsConstructor
public class ServerConnectionManager {

    private final UserManager userManager;
    private final ServerPacketManager packetManager;

    public boolean handleConnection(ServerBoundConnectionPacket packet, InetSocketAddress sockerAddr){
        int userID = packet.getClientID();



        if(userID == 0){
            userID = userManager.getUserCounter().getAndIncrement();
        }



        User user = new User(userID,sockerAddr);

        if(userManager.hasUser(user)){
            System.out.println("USER EXISTS");
            return false;
        }

        userManager.addUser(user);

        ClientBoundConnectionAckPacket ackPacket = new ClientBoundConnectionAckPacket(user.getUserID());
        System.out.println(packet.getHostAddress()+" has joined the server with userID: "+userID);
        packetManager.sendPacket(new PacketSendable(ackPacket, sockerAddr));
        return true;
    }

}
