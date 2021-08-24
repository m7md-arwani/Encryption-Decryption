package encryptdecrypt;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hash = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            hash.put(args[i], args[i + 1]);
        }
        commandLineInput(hash);


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

    //@Overloaded version of Encryption

    public static void EncryptionAlgorithm(String mes, String out, int key) {
        StringBuilder str = new StringBuilder(mes);// Text to cipher.
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            ch += key; // ciphering.
            if (ch > 126) {
                ch -= 94;
            }
            str.setCharAt(i, ch);

        }
        writeFile(str.toString(), out);


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

    //@Overloaded version of Decryption

    public static void DecryptionAlgorithm(String st, String outPath, int key) {
        StringBuilder str = new StringBuilder(st);// Text to decipher.
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            ch -= key; // deciphering.
            if (ch > 126) {
                ch += 94;
            }
            str.setCharAt(i, ch);

        }
        writeFile(str.toString(), outPath);

    }

    public static String readFile(String path) {

        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    public static void writeFile(String text, String path) {
        try {
            FileWriter write = new FileWriter(path);
            write.append(text);
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commandLineInput(HashMap<String, String> hash) {

        String message = "";
        String inPath;
        String outPath = "";
        int key;


        if ("".equals(hash.get("-key"))) {
            key = 0;
        } else {
            key = Integer.parseInt(hash.get("-key"));
        }

        if (hash.containsKey("-out")) {
            outPath = hash.get("-out");

        }

        if (!hash.containsKey("-data") && !hash.containsKey("-in")) {
            message = "";

        } else if (hash.containsKey("-data") && hash.containsKey("-in")) {
            message = hash.get("-data");

        } else if (!hash.containsKey("-data") && hash.containsKey("-in")) {
            inPath = hash.get("-in");
            message = readFile(inPath);


        }


        if ("dec".equals(hash.get("-mode"))) {
            if (!hash.containsKey("-out")) {
                DecryptionAlgorithm(message, key);
            } else if (hash.containsKey("-in") && hash.containsKey("-out")) {
                DecryptionAlgorithm(message, outPath, key);
            }

        } else {
            if (!hash.containsKey("-out")) {
                EncryptionAlgorithm(message, key);
            } else if (hash.containsKey("-in") && hash.containsKey("-out")) {
                EncryptionAlgorithm(message, outPath, key);
            }


        }


    }
}
