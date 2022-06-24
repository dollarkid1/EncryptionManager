package com.condueet.encryptionanddecryptionwithrsa;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSA3Test {

    RSA3 rsa;

    @BeforeEach
    void setUp() {
        rsa = new RSA3();
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


    /*This test method is totally different from the encryptAndDecrypt2 in RSATest1*/
    @Test
    void encryptAndDecrypt2() {

        rsa.initFromStrings();

        try{
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://localhost:3000/getSecretMessage")
                    .method("GET", null)
                    .build();

            Response response = client.newCall(request).execute();

            String encryptedMessage = response.body().string();
            System.err.println("RESPONSE BODY = "+ encryptedMessage);

            String secretMessage = rsa.decrypt(encryptedMessage);
            System.err.println("SECRET MESSAGE = "+secretMessage);


        }catch (Exception ignored){}
    }



}