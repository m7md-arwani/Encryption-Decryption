package encryptdecrypt;

// Encryption class contains two types unicode and shift.
// "type" parameter will decide which type to go with. True ---> Unicode. False ---> Shift
public class Encryption implements TextActivity {
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
                    // depending on letters sizes, this variable will hold different ascii code.
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