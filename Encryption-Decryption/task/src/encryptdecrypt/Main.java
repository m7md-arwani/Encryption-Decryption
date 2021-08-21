package encryptdecrypt;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner g = new Scanner(System.in);
        String operation = g.nextLine();
        String message = g.nextLine();
        int key = g.nextInt();
        switch (operation) {
            case "enc":
                EncryptionAlgorithm(message, key);
                break;
            case "dec":
                DecryptionAlgorithm(message, key);
                break;
            default:
                System.out.println("Wrong operation");
                break;
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
