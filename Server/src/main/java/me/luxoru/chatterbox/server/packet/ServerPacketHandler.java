package me.luxoru.chatterbox.server.packet;

import lombok.AllArgsConstructor;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundPacket;
import me.luxoru.chatterbox.server.Server;
import me.luxoru.netsync.commons.Packet;
import me.luxoru.netsync.commons.handler.PacketHandler;

import java.net.InetSocketAddress;

@AllArgsConstructor
public class ServerPacketHandler implements PacketHandler {

    private final Server server;


    @Override
    public <T extends Packet> void handle(T packet, InetSocketAddress inetSocketAddress) {
        if(!(packet instanceof ServerBoundPacket)) return;

        if(packet instanceof ServerBoundConnectionPacket connectionPacket){

        }

    }
}
