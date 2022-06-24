package com.condueet.encryptionanddecryptionwithrsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    RSA rsa;

    @BeforeEach
    void setUp() {
      rsa = new RSA();
    }

    @Test
    void encryptAndDecrypt() {
        try{
            String encryptedMessage = rsa.encrypt("Hello World");
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encrypted:\n"+encryptedMessage);
            System.err.println("Decrypted:\n"+decryptedMessage);

        }catch (Exception ignored){}
    }


}