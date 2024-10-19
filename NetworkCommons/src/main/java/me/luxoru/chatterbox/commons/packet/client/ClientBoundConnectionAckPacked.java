package me.luxoru.chatterbox.commons.packet.client;

import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.netsync.commons.Packet;
import me.luxoru.netsync.commons.utils.ArrayUtils;

import java.util.UUID;

public class ClientBoundConnectionAckPacked extends ClientBoundPacket{

    private int clientID;

    public ClientBoundConnectionAckPacked() {
        super(ChatterBoxPacketFactory.getID(ClientBoundConnectionAckPacked.class));
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = super.toBytes();
        byte[] clientIDBytes = this.clientID.toString().getBytes();
        byte[] newBytes = new byte[bytes.length+clientIDBytes.length];
        System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
        System.arraycopy(clientIDBytes, 0, newBytes, bytes.length, clientIDBytes.length);
        return newBytes;
    }

    @Override
    public ClientBoundConnectionAckPacked fromBytes(byte[] bytes) {
        super.fromBytes(bytes);

        byte[] uuidBytes = ArrayUtils.getFrom(4, bytes);
        String uuid = new String(uuidBytes);

        this.clientID = UUID.fromString(uuid);

        return this;
    }
}
