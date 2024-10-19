package me.luxoru.chatterbox.server.packet;


import me.luxoru.netsync.commons.PacketManager;
import me.luxoru.netsync.commons.handler.PacketHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerPacketManager extends PacketManager {


    public ServerPacketManager(int port, long sleepDelay, PacketHandler handler) {
        super(port, sleepDelay, handler);
    }

    @Override
    protected void connect() throws IOException {
        channel.bind(new InetSocketAddress(port));
    }

    @Override
    protected boolean shouldRead(InetSocketAddress inetSocketAddress) {
        return true;
    }
}
