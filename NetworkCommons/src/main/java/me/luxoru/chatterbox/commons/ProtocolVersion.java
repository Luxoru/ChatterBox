package me.luxoru.chatterbox.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProtocolVersion {

    V1(1);


    private final int protocolID;




}
