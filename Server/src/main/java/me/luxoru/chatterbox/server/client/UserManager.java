package me.luxoru.chatterbox.server.client;

import java.util.HashSet;
import java.util.Set;

public class UserManager {

    private Set<User> users;

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


}
