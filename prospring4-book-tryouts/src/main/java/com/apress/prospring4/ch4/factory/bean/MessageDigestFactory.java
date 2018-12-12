package com.apress.prospring4.ch4.factory.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Vadym Mitin
 */
public class MessageDigestFactory {
    private String algorithm = "MD5";

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
