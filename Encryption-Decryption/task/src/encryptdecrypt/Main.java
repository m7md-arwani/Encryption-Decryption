package encryptdecrypt;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


class FileOperation {
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
}

class Text {

    private TextActivity act;


    public Text(TextActivity act) {
        this.act = act;
    }

    public void process(String mes, String out, int key, boolean type) {
        this.act.processText(mes, out, key, type);
    }

    public void process(String mes, int key, boolean type) {
        this.act.processText(mes, key, type);
    }

}

interface TextActivity {
    void processText(String mes, String out, int key, boolean type);

    void processText(String mes, int key, boolean type);

}

class Encryption implements TextActivity {
    @Override
    public void processText(String mes, String out, int key, boolean type) {
        if (type) {
            StringBuilder str = new StringBuilder(mes);// Text to cipher.
            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);
                ch += key; // ciphering.
                if (ch > 126) {
                    ch -= 94;
                }
                str.setCharAt(i, ch);

            }
            FileOperation.writeFile(str.toString(), out);

        } else {
            StringBuilder result = new StringBuilder();
            for (char character : mes.toCharArray()) {
                if (Character.isLetter(character)) {
                    char ascii;
                    if (Character.isUpperCase(character)) {
                        ascii = 'A';
                    } else {
                        ascii = 'a';
                    }

                    int originalAlphabetPosition = character - ascii;
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    char newCharacter = (char) (ascii + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }

            }
            FileOperation.writeFile(result.toString(), out);

        }


    }

    @Override
    public void processText(String mes, int key, boolean type) {
        if (type) {
            StringBuilder str = new StringBuilder(mes);// Text to cipher.
            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);
                ch += key; // ciphering.
                if (ch > 126) {
                    ch -= 94;
                }
                str.setCharAt(i, ch);

            }
            System.out.println(str);

        } else {
            StringBuilder result = new StringBuilder();
            for (char character : mes.toCharArray()) {
                if (Character.isLetter(character)) {
                    char ascii;
                    if (Character.isUpperCase(character)) {
                        ascii = 'A';
                    } else {
                        ascii = 'a';
                    }

                    int originalAlphabetPosition = character - ascii;
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    char newCharacter = (char) (ascii + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }

            }
            System.out.println(result);

        }


    }
}

class Decryption implements TextActivity {
    @Override
    // to a file
    public void processText(String mes, String out, int key, boolean type) {
        if (type) {
            StringBuilder str = new StringBuilder(mes);// Text to decipher.
            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);
                ch -= key; // deciphering.
                if (ch > 126) {
                    ch += 94;
                }
                str.setCharAt(i, ch);

            }
            FileOperation.writeFile(str.toString(), out);

        } else {
            new Encryption().processText(mes, out, 26 - (key % 26), false);

        }


    }

    // to the standard output
    public void processText(String mes, int key, boolean type) {
        if (type) {
            StringBuilder str = new StringBuilder(mes);// Text to decipher.
            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);
                ch -= key; // deciphering.
                if (ch > 126) {
                    ch += 94;
                }
                str.setCharAt(i, ch);

            }
            System.out.println(str);

        } else {
            new Encryption().processText(mes, 26 - (key % 26), false);

        }


    }
}


public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hash = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            hash.put(args[i], args[i + 1]);
        }
        commandLineInput(hash);


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
            message = FileOperation.readFile(inPath);


        }
        // if true, Unicode & if false, shift
        // default case is shift
        boolean typeFlag = false;
        if (hash.containsKey("-alg")) {
            if ("unicode".equals(hash.get("-alg"))) {
                typeFlag = true;
            }
        }


        Text text;
        if ("dec".equals(hash.get("-mode"))) {
            if (!hash.containsKey("-out")) {
                text = new Text(new Decryption());
                text.process(message, key, typeFlag);
            } else if (hash.containsKey("-in") && hash.containsKey("-out")) {
                text = new Text(new Decryption());
                text.process(message, outPath, key, typeFlag);
            }

        } else {
            if (!hash.containsKey("-out")) {
                text = new Text(new Encryption());
                text.process(message, key, typeFlag);
            } else if (hash.containsKey("-in") && hash.containsKey("-out")) {
                text = new Text(new Encryption());
                text.process(message, outPath, key, typeFlag);
            }


        }


    }
}
