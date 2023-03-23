package encryption_algorithm;

import java.util.*;
/**
 * @authors Marios Petrov / Megan Pelletier
 * @version 1.0
 * @since March 2023
 */

public class CaesarCipher implements Encryption {

    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public int shiftBit;

    public CaesarCipher(int shiftBit) {
        this.shiftBit = shiftBit;
    }

    public String encrypt(String plainText) {

        // convert inputStr into lower case
        String inputStr = plainText.toLowerCase();
        // encryptStr to store encrypted data
        String encryptStr = "";
        // use for loop for traversing each character of the input string

        for (int i = 0; i < inputStr.length(); i++)
        {
            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if (pos == -1) {
                encryptStr += inputStr.charAt(i);
                continue;
            }
            // get encrypted char for each char of inputStr
            int encryptPos = (shiftBit + pos) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);
            // add encrypted char to encrypted string
            encryptStr += encryptChar;
        }
        // return encrypted string
        return encryptStr;
    }

    public String decrypt(String encryptText) {

        // convert inputStr into lower case
        String inputStr = encryptText.toLowerCase();
        // decryptStr to store decrypted data
        String decryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++)
        {
            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if (pos == -1) {
                decryptStr += inputStr.charAt(i);
                continue;
            }
            // get decrypted char for each char of inputStr
            int decryptPos = (pos - shiftBit) % 26;
            // if decryptPos is negative
            if (decryptPos < 0){
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);
            // add decrypted char to decrypted string
            decryptStr += decryptChar;
        }
        // return decrypted string
        return decryptStr;
    }

    //'encrypt' and 'decrypt' were partially implemented using: https://www.javatpoint.com/caesar-cipher-program-in-java
}
