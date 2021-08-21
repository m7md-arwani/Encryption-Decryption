package encryptdecrypt;



public class Main {
    public static void main(String[] args) {

        String input = "we found a treasure!";
        StringBuilder str = new StringBuilder(input);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                str.setCharAt(i, counterpartFinder(str.charAt(i)));
            }
        }
        System.out.println(str);
    }


    // The parameter 'ch' is the letter that we want to cipher.
    public static char counterpartFinder(char ch) {
        char[] letters = new char[26]; // Will hold all the alphabet (lower case)
        char ascii = 'a'; // starting from the letter "a" lower case.
        for (int i = 0; i < letters.length; i++) {
            letters[i] = ascii;
            ascii++;
        }
        int index = 0;
        for (int i = 0; i < letters.length; i++) {
            // looking for the letter in alphabet array.
            if (letters[i] == ch) {
                // this general equation should give us any letter's counterpart from the other end.
                index = letters.length - i - 1;

            }
        }
        return letters[index];


    }
}
