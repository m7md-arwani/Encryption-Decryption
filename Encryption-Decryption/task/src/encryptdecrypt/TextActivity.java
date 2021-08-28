package encryptdecrypt;

// In strategy design pattern, an interface is required.
public interface TextActivity {
    // In case the output should be directed to a file.
    void processText(String mes, String out, int key, boolean type);
    // In case the input is from a file or from the console.
    void processText(String mes, int key, boolean type);

}
