package me.luxoru.chatterbox.commons.packet.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;

@NoArgsConstructor
@Getter
public class ClientBoundConnectionAckPacket extends ClientBoundPacket{

    //Represented as 2 bytes
    private int clientID;

    public ClientBoundConnectionAckPacket(int clientID) {
        super(ChatterBoxPacketFactory.getID(ClientBoundConnectionAckPacket.class));
        this.clientID = clientID;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = super.toBytes();
        byte upper = (byte) (clientID >> 8);
        byte lower = (byte) clientID;
        byte[] newBytes = new byte[bytes.length + 2];
        System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
        newBytes[bytes.length] = upper;
        newBytes[bytes.length + 1] = lower;
        return newBytes;
    }

    @Override
    public ClientBoundConnectionAckPacket fromBytes(byte[] bytes) {
        super.fromBytes(bytes);

        this.clientID = (bytes[4] << 8) | (bytes[5] & 0xFF);
        return this;
    }
}
