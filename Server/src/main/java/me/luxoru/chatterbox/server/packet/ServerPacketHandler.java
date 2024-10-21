package me.luxoru.chatterbox.server.packet;

import lombok.AllArgsConstructor;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundPacket;
import me.luxoru.chatterbox.server.Server;
import me.luxoru.chatterbox.server.client.UserManager;
import me.luxoru.chatterbox.server.connection.ServerConnectionManager;
import me.luxoru.netsync.commons.Packet;
import me.luxoru.netsync.commons.handler.PacketHandler;

import java.net.InetSocketAddress;


public class ServerPacketHandler implements PacketHandler {


    private final UserManager userManager = new UserManager();
    private ServerConnectionManager connectionManager;
    private final Server server;

    public ServerPacketHandler(Server server) {
        this.server = server;
    }


    public void init(){
        this.connectionManager = new ServerConnectionManager(userManager, server.getServerPacketManager());
    }


    @Override
    public <T extends Packet> void handle(T packet, InetSocketAddress inetSocketAddress) {
        if(!(packet instanceof ServerBoundPacket)) return;

        if(packet instanceof ServerBoundConnectionPacket connectionPacket){
            connectionManager.handleConnection(connectionPacket, inetSocketAddress);
        }

    }
}
