package me.luxoru.chatterbox.server.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.UUID;


@Getter
public record User(int userID, InetSocketAddress ephemeralAddress) {

}
