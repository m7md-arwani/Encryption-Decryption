package encryptdecrypt;

public interface TextActivity {
    void processText(String mes, String out, int key, boolean type);

    void processText(String mes, int key, boolean type);

}
