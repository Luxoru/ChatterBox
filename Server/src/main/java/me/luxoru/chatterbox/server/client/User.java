package me.luxoru.chatterbox.server.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.InetSocketAddress;
import java.util.Objects;

@AllArgsConstructor
@Getter
public final class User{
    private final int userID;
    private final InetSocketAddress socketAddress;

}
