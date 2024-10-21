package me.luxoru.chatterbox.server.client;

import lombok.Getter;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class UserManager {

    private Set<User> users;
    @Getter
    private final AtomicInteger userCounter = new AtomicInteger(1);

    public UserManager(){
        this.users = new HashSet<>();
    }


    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public boolean hasUser(User user){
        return this.users.contains(user);
    }

    public boolean hasUser(int userId, InetAddress address){
        int hash = Objects.hash(userId, address);
        for(User user : this.users){
            if(user.hashCode() == hash)return true;
        }
        return false;
    }


}
