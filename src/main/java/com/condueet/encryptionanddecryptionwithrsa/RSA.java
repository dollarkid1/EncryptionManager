package com.condueet.encryptionanddecryptionwithrsa;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;


public class RSA {

    private PrivateKey privatekey;
    private PublicKey publicKey;

    public RSA() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privatekey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {
        }
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String encrypt(String message) throws Exception {

        byte[] messageToBytes = message.getBytes();

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = cipher.doFinal(messageToBytes);

        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {

        byte[] encryptedBytes = decode(encryptedMessage);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privatekey);

        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);

        return new String(decryptedMessage, StandardCharsets.UTF_8);
    }


}
