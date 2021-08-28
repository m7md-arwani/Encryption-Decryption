package encryptdecrypt;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

// A class to read and write files.
// To reduce duplicated code.
public class FileOperation {
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
