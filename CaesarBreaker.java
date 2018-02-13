
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    private void countWordLengths (FileResource resource, int []counts) {
        for(String s : resource.words()) {
            int idx = s.length();
            if(!Character.isLetter(s.charAt(0))) {
                idx -= 1;
            }
            if(!Character.isLetter(s.charAt(idx-1))) {
                idx -= 1;
            }
            if(idx >= counts.length) {
                counts[counts.length - 1] ++;
            }
            else {
                counts[idx]++;
            }
        }
    }
    private int indexOfMax (int []values) {
        int idx = 0;
        for(int i = 1; i<values.length; i++) {
            if(values[i] > values[idx]) {
                idx = i;
            }
        }
        return idx;
    }
    public String halfOfString (String message, int start) {
        String s = "";
        for(int i=start ; i<message.length() ; i=i+2) {
            s = s + message.charAt(i);
        }
        return s;
    }
    private int[] countLetters (String s) {
        int []letters = new int[26];
        for (int i=0; i<26; i++) {
            letters[i] = 0;
        }
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<s.length() ; i++) {
            if(Character.isLetter(s.charAt(i))) {
                int idx = alphabets.indexOf(Character.toLowerCase(s.charAt(i)));
                letters[idx] ++;
            }
        }
        return letters;
    }
    private int getKey (String s) {
        int[] freqs = countLetters(s);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    private String decryptTwoKeys(String encrypted) {
        String s1 = halfOfString(encrypted, 0);
        String s2 = halfOfString(encrypted, 1);
        int key1 = getKey (s1);
        int key2 = getKey (s2);
        System.out.println("Key 1 : "+key1);
        System.out.println("Key 2 : "+key2);
        CaesarCipher cc1 = new CaesarCipher();
        String decrypted = cc1.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        return decrypted;
    }
    private String decrypt (String encrypted) {
        int key = getKey (encrypted);
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26-key);
        return message;
    }
    public void testDecrypt() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("Decrypted message : "+decrypt(message));
    }
    public void testDecryptTwoKeys () {
        FileResource fr = new FileResource();
        String message = fr.asString(); 
        System.out.println("Decrypted message : "+decryptTwoKeys(message));
    }
}
