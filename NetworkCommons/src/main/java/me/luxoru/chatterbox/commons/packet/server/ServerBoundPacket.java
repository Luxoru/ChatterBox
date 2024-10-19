package me.luxoru.chatterbox.commons.packet.server;

import lombok.NoArgsConstructor;
import me.luxoru.chatterbox.commons.ProtocolVersion;
import me.luxoru.netsync.commons.Packet;

@NoArgsConstructor
public abstract class ServerBoundPacket extends Packet {

    public ServerBoundPacket(int packetID){
        super(ProtocolVersion.V1.getProtocolID(), packetID);
    }

}
