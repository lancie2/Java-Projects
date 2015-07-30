/**
 * Author: Lancie Menchu
 * Date: 10/05/2012
 * CS 312 Assignment 4
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This program accepts a user provided string and applies a caesar
 * cipher to it.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 */

//import java utiity library
import java.util.*;

public class CaesarCipher {

    public static void main(String[] args) {
        
        //create scanner object
        Scanner read = new Scanner(System.in);
        
        //prompt the user for a cipher key
        System.out.print("Pick a cipher key: ");
        int userKey = read.nextInt();
        
        //prmpt user for text and store the value into a string
        System.out.print("Plaintext - uppercase letters only: ");
        String userText = read.next();
        
        //encrypt the text using the Caesar cipher
        String cipher = encryptCaesar(userText, userKey);
        System.out.println("Chiphertext: " + cipher);
        
        //prompt user for the cipher text
        System.out.print("Enter ciphertext - uppercase only: ");
        String ciphertext = read.next();
        
        //display all possible decryptions using keys 1-25
        printPlain(ciphertext);
        
        
    }
    
    //take a string and encrypt it using the Caesar cipher
    public static String encryptCaesar(String plaintext, int key) {
        String encryptedText = new String();
        for(int index = 0; index < plaintext.length(); index++) {
            encryptedText += encryptChar(plaintext.charAt(index), key);
        }
        return encryptedText;
    }
    
    //take in character and modify it using the Caesar Cypher key, adding the key to its ASCII value
    public static char encryptChar(char ch, int key) {
        ch += key + 26 - 65;
        ch %= 26;
        ch += 65;
        return  ch;
    }
    
    //return decrypted char, by passing the char and negative key to encrypt char method
    public static char decryptChar(char ch, int key) {
        char decryptedCh = encryptChar(ch, -key);
        return decryptedCh;
    }
    
    //returns options for 25 keys to translate encrypted text back to plain text
    public static void printPlain(String cipher) {
        char ch;
        System.out.println("Plaintext for each encryption key from 1 to 25:");
        for(int key = 1; key <= 25; key++) {
            String plainText = new String();
            for(int index = 0; index < cipher.length(); index++) {
                ch = cipher.charAt(index);
                ch = decryptChar(ch, key);
                plainText += ch;
            }
            System.out.println("Key " + key + ": plaintext = " + plainText);
        }
    }

}

/* SAMPLE OUTPUT

Pick a cipher key: 4
Plaintext - uppercase letters only: HOOK
Chiphertext: LSSO
Enter ciphertext - uppercase only: LSSO
Plaintext for each encryption key from 1 to 25:
Key 1: plaintext = KRRN
Key 2: plaintext = JQQM
Key 3: plaintext = IPPL
Key 4: plaintext = HOOK
Key 5: plaintext = GNNJ
Key 6: plaintext = FMMI
Key 7: plaintext = ELLH
Key 8: plaintext = DKKG
Key 9: plaintext = CJJF
Key 10: plaintext = BIIE
Key 11: plaintext = AHHD
Key 12: plaintext = ZGGC
Key 13: plaintext = YFFB
Key 14: plaintext = XEEA
Key 15: plaintext = WDDZ
Key 16: plaintext = VCCY
Key 17: plaintext = UBBX
Key 18: plaintext = TAAW
Key 19: plaintext = SZZV
Key 20: plaintext = RYYU
Key 21: plaintext = QXXT
Key 22: plaintext = PWWS
Key 23: plaintext = OVVR
Key 24: plaintext = NUUQ
Key 25: plaintext = MTTP

*/
