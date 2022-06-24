package com.condueet.encryptionanddecryptionwithrsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSA1Test {

    RSA1 rsa;

    @BeforeEach
    void setUp() {
        rsa = new RSA1();
    }

    @Test
    void encryptAndDecrypt() {

        rsa.init();

        rsa.printKeys();

        try{
            String encryptedMessage = rsa.encrypt("Hello World");
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encrypted:\n"+encryptedMessage);
            System.err.println("Decrypted:\n"+decryptedMessage);

        }catch (Exception ignored){}
    }

    @Test
    void encryptAndDecrypt2() {

        rsa.initFromStrings();

        try{
            String encryptedMessage = rsa.encrypt("Hello World");
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encrypted:\n"+encryptedMessage);
            System.err.println("Decrypted:\n"+decryptedMessage);

        }catch (Exception ignored){}
    }


}