package me.luxoru.chatterbox.commons.packet.server;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;
import me.luxoru.netsync.commons.Packet;
import me.luxoru.netsync.commons.utils.ArrayUtils;

import java.net.InetSocketAddress;

@Getter
@NoArgsConstructor
public class ServerBoundConnectionPacket extends ServerBoundPacket{

    private String hostAddress;
    private int clientID;


    public ServerBoundConnectionPacket(int clientID, String hostAddress) {
        super(ChatterBoxPacketFactory.getID(ServerBoundConnectionPacket.class));
        this.hostAddress = hostAddress;
        this.clientID = clientID;

    }
    public ServerBoundConnectionPacket(String hostAddress) {
        super(ChatterBoxPacketFactory.getID(ServerBoundConnectionPacket.class));
        this.hostAddress = hostAddress;
    }


    @Override
    public byte[] toBytes() {
        byte[] bytes = super.toBytes();
        byte[] hostBytes = hostAddress.getBytes();
        byte[] newBytes = new byte[bytes.length + hostBytes.length+2];
        System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
        byte upper = (byte) (clientID >> 8);
        byte lower = (byte) (clientID);
        newBytes[bytes.length] = upper;
        newBytes[bytes.length+1] = lower;
        System.arraycopy(hostBytes, 0, newBytes, bytes.length+2, hostBytes.length);
        return newBytes;
    }

    @Override
    public ServerBoundConnectionPacket fromBytes(byte[] bytes) {
        super.fromBytes(bytes);
        int clientID = (bytes[4] << 8) | (bytes[5] & 0xFF);
        byte[] hostBytes = ArrayUtils.getFrom(6, bytes);

        this.hostAddress = new String(hostBytes);
        this.clientID = clientID;;
        return this;

    }
}
