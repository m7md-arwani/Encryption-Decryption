package encryptdecrypt;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner g = new Scanner(System.in);
        String text = g.nextLine();
        int key = g.nextInt();
        System.out.println(EncryptionAlgorithm(text, key));

    }


    public static String EncryptionAlgorithm(String st, int key) {
        StringBuilder str = new StringBuilder(st);// Text to cipher.
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                char ch = str.charAt(i);
                ch += key; // ciphering.
                if (ch > 122) {
                    ch -= 26;
                }
                str.setCharAt(i, ch);
            }
        }
        return str.toString();
    }
}
