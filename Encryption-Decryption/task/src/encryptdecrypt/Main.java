package encryptdecrypt;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        // Using a hashmap to collect arguments as pairs <String,String>
        HashMap<String, String> hash = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            hash.put(args[i], args[i + 1]);
        }
        commandLineInput(hash);


    }

    // According to the values in the hash, the behavior should change.
    public static void commandLineInput(HashMap<String, String> hash) {

        String message = "";
        String inPath; // The path of the file which will be read from.
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
        // variable message, could have two sources. A file or the console as an argument of main.


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
