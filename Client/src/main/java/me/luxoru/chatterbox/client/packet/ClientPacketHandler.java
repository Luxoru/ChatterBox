package me.luxoru.chatterbox.client.packet;

import me.luxoru.chatterbox.commons.packet.client.ClientBoundConnectionAckPacket;
import me.luxoru.netsync.commons.Packet;
import me.luxoru.netsync.commons.handler.PacketHandler;

import java.net.InetSocketAddress;

public class ClientPacketHandler implements PacketHandler {
    @Override
    public <T extends Packet> void handle(T packet, InetSocketAddress inetSocketAddress) {
        if(packet instanceof ClientBoundConnectionAckPacket connectionAckPacket){
            System.out.println("CLIENT ID: "+connectionAckPacket);
        }
    }
}
