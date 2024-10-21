package me.luxoru.chatterbox.commons.packet.client;

import lombok.NoArgsConstructor;
import me.luxoru.chatterbox.commons.ProtocolVersion;
import me.luxoru.netsync.commons.Packet;

@NoArgsConstructor
public class ClientBoundPacket extends Packet {

    public ClientBoundPacket(int packetID){
        super(ProtocolVersion.V1.getProtocolID(), packetID);
    }

}
