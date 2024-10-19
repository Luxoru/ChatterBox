package me.luxoru.chatterbox.client;

import lombok.SneakyThrows;
import me.luxoru.chatterbox.client.packet.ClientPacketHandler;
import me.luxoru.chatterbox.client.packet.ClientPacketManager;
import me.luxoru.chatterbox.commons.packet.ChatterBoxPacketFactory;
import me.luxoru.chatterbox.commons.packet.server.ServerBoundConnectionPacket;
import me.luxoru.netsync.commons.PacketFactory;
import me.luxoru.netsync.commons.PacketSendable;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.Scanner;

public class Client {

    @SneakyThrows
    public Client(){

        System.out.println("Enter host for the server to connect to: ");
        Scanner scanner = new Scanner(System.in);
        String host = scanner.nextLine();
        System.out.println("Enter port for the server: ");
        int port = scanner.nextInt();

        System.out.printf("Attempting to connect to: %s:%s%n", host, port);

        InetSocketAddress server = new InetSocketAddress(host, port);

        ClientPacketManager packetManager = new ClientPacketManager(host, port, 20, new ClientPacketHandler());

        packetManager.start();
        PacketFactory.init(ChatterBoxPacketFactory.getPackets());
        packetManager.sendPacket(new PacketSendable(new ServerBoundConnectionPacket(InetAddress.getLocalHost().getHostAddress()), server));

    }

    public static void main(String[] args) throws IOException {
        new Client();
    }

}
