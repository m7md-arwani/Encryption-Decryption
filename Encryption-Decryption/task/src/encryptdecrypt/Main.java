package encryptdecrypt;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hash = new HashMap<>();
        String message;
        int key;
        for (int i = 0; i < args.length; i += 2) {
            hash.put(args[i], args[i + 1]);
        }
        if ("".equals(hash.get("-data"))) {
            message = "";
        } else {
            message = hash.get("-data");
        }

        if ("".equals(hash.get("-key"))) {
            key = 0;
        } else {
            key = Integer.parseInt(hash.get("-key"));
        }

        if ("dec".equals(hash.get("-mode"))) {
            DecryptionAlgorithm(message, key);
        } else {
            EncryptionAlgorithm(message, key);
        }


    }


    public static void EncryptionAlgorithm(String st, int key) {
        StringBuilder str = new StringBuilder(st);// Text to cipher.
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            ch += key; // ciphering.
            if (ch > 126) {
                ch -= 94;
            }
            str.setCharAt(i, ch);

        }
        System.out.println(str);
    }

    public static void DecryptionAlgorithm(String st, int key) {
        StringBuilder str = new StringBuilder(st);// Text to decipher.
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            ch -= key; // deciphering.
            if (ch > 126) {
                ch += 94;
            }
            str.setCharAt(i, ch);

        }
        System.out.println(str);

    }
}
