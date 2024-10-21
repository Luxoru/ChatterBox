package me.luxoru.chatterbox.commons.util;

import lombok.SneakyThrows;

import java.security.MessageDigest;
import java.util.UUID;

public class UUIDGenerator {

    @SneakyThrows
    public static UUID generateFromString(String ipAddress){

        byte[] ipBytes = ipAddress.getBytes();


        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hash = sha1.digest(ipBytes);


        long mostSigBits = 0;
        long leastSigBits = 0;

        for (int i = 0; i < 8; i++) {
            mostSigBits <<= 8;
            mostSigBits |= (hash[i] & 0xff);
        }

        for (int i = 8; i < 16; i++) {
            leastSigBits <<= 8;
            leastSigBits |= (hash[i] & 0xff);
        }

        return new UUID(mostSigBits, leastSigBits);
    }

}
