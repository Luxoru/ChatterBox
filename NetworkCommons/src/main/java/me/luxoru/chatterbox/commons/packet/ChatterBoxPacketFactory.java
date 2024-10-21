package me.luxoru.chatterbox.commons.packet;

import lombok.Getter;
import me.luxoru.chatterbox.commons.packet.client.ClientBoundConnectionAckPacket;
import me.luxoru.chatterbox.commons.packet.client.ClientBoundPacket;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.netsync.commons.Packet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ChatterBoxPacketFactory {

    @Getter
    private static final Map<Integer, Class<? extends Packet>> packets = new ConcurrentHashMap<>();
    private static final Map<Class<? extends Packet>, Integer> packetToIdMap = new ConcurrentHashMap<>();

    static {
        packets.put(1, ServerBoundConnectionPacket.class);
        packetToIdMap.put(ServerBoundConnectionPacket.class, 1);
        packets.put(2, ClientBoundConnectionAckPacket.class);
        packetToIdMap.put(ClientBoundConnectionAckPacket.class, 2);
    }


    public static int getID(Class<? extends Packet> packet){
        return packetToIdMap.get(packet);
    }
}
