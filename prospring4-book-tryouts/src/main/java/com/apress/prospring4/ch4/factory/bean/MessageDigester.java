package com.apress.prospring4.ch4.factory.bean;

import java.security.MessageDigest;

/**
 * @author Vadym Mitin
 */
public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("using digest1");
        digest(msg, digest1);

        System.out.println("using digest1");
        digest(msg, digest2);

    }

    public void digest(String msg, MessageDigest msgDigest) {
        System.out.println("Using algorithm: " + msgDigest.getAlgorithm());
        msgDigest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = msgDigest.digest(bytes);
        System.out.println(out);
    }

}
