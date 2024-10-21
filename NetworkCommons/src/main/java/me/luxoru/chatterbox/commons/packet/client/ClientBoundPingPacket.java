package me.luxoru.chatterbox.commons.packet.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;
import me.luxoru.netsync.commons.Packet;

@Getter
@NoArgsConstructor
public class ClientBoundPingPacket extends ClientBoundPacket{
    private long timeSent;

    public ClientBoundPingPacket(int pingID) {
        super(ChatterBoxPacketFactory.getID(ClientBoundPingPacket.class));
        this.timeSent = pingID;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = super.toBytes();
        byte
    }

    @Override
    public Packet fromBytes(byte[] bytes) {
        return super.fromBytes(bytes);
    }
}
