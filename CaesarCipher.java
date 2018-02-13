import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            else {
                currChar = Character.toUpperCase(currChar);
                idx = alphabet.indexOf(currChar);
                if(idx != -1) {
                     char newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                     encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public String encryptTwoKeys (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar;
                if(i%2 ==0) {
                   newChar = shiftedAlphabet1.charAt(idx);
                }
                else {
                   newChar = shiftedAlphabet2.charAt(idx);
                }
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            else {
                currChar = Character.toUpperCase(currChar);
                idx = alphabet.indexOf(currChar);
                if(idx != -1) {
                    char newChar;
                     if(i%2 == 0) {
                        newChar = Character.toLowerCase(shiftedAlphabet1.charAt(idx));
                     }
                     else {
                        newChar = Character.toLowerCase(shiftedAlphabet2.charAt(idx));
                     }
                     encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public void testAdCaesar() {
        int key1 = 24;
        int key2 = 6;
        String message = "Top ncmy qkff vi vguv vbg ycpx";
        String encrypted = encryptTwoKeys(message,key1,key2);
        System.out.println(encrypted);
    }
}

