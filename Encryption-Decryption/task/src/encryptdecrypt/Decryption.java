package encryptdecrypt;

public class Decryption implements TextActivity {
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
