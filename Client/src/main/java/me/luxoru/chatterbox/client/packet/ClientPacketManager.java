package me.luxoru.chatterbox.client.packet;

import me.luxoru.netsync.commons.PacketManager;
import me.luxoru.netsync.commons.handler.PacketHandler;


import java.io.IOException;
import java.net.InetSocketAddress;

public class ClientPacketManager extends PacketManager {

    private InetSocketAddress socketAddress;

    public ClientPacketManager(String host, int port, long sleepDelay, PacketHandler handler) {
        super(host, port, sleepDelay, handler);
    }

    @Override
    protected void connect() throws IOException {
        this.socketAddress = new InetSocketAddress(0);
        channel.bind(socketAddress);
    }

    @Override
    protected boolean shouldRead(InetSocketAddress inetSocketAddress) {
        return !(socketAddress.equals(inetSocketAddress));
    }
}
