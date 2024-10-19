package me.luxoru.chatterbox.server;


import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;
import me.luxoru.chatterbox.server.connection.ServerConnectionManager;
import me.luxoru.chatterbox.server.packet.ServerPacketHandler;
import me.luxoru.chatterbox.server.packet.ServerPacketManager;
import me.luxoru.netsync.commons.PacketFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {

    private ServerConnectionManager manager;
    private final ServerPacketManager serverPacketManager;

    public Server(int port) throws UnknownHostException {
        manager = new ServerConnectionManager();
        serverPacketManager = new ServerPacketManager(port, 20, new ServerPacketHandler());
        serverPacketManager.start();
        PacketFactory.init(ChatterBoxPacketFactory.getPackets());
        System.out.printf("Server running on %s:%s%n",InetAddress.getLocalHost().getHostAddress(), port);

    }


    public static void main(String[] args) {
        System.out.println("Enter port to start server on: ");
        Scanner scanner = new Scanner(System.in);
        int port = scanner.nextInt();
        try {
            new Server(port);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}