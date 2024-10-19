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


    public ServerBoundConnectionPacket(String hostAddress) {
        super(ChatterBoxPacketFactory.getID(ServerBoundConnectionPacket.class));
        this.hostAddress = hostAddress;

    }


    @Override
    public byte[] toBytes() {
        byte[] bytes = super.toBytes();
        byte[] hostBytes = hostAddress.getBytes();
        byte[] newBytes = new byte[bytes.length + hostBytes.length];
        System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
        System.arraycopy(hostBytes, 0, newBytes, bytes.length, hostBytes.length);
        return newBytes;
    }

    @Override
    public ServerBoundConnectionPacket fromBytes(byte[] bytes) {
        super.fromBytes(bytes);

        byte[] hostBytes = ArrayUtils.getFrom(4, bytes);

        this.hostAddress = new String(hostBytes);

        return this;

    }
}
