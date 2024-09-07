// Create a polyalphabetic substitution cipher,
// implement it in any programming language,
// encrypt a message using your cipher, and then decrypt it.
// Describe the advantages and disadvantages of the cipher.

// Advantages:
//  - Simple to implement
//  - Resistant to basic attacks due to the use of a key
//  - Can encrypt not just letters, but also numbers, punctuation, etc.

// Disadvantages:
//  - Vulnerable to frequency analysis
//  - If the key is shorter than the message, it becomes less effective
//  - Not all possible symbols are encrypted

package lab1_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine().toLowerCase();
        System.out.print("Enter key string: ");
        String key = scanner.nextLine().toLowerCase();

        String alp = "abcdefghijklmnopqrstuvwxyz1234567890.,<>/\\*-+@#!$%^&*()= ";
        String encryptStr = encrypt(alp, inputStr, key);
        System.out.println("encrypt: " + encryptStr);

        String decryptStr = decrypt(alp, encryptStr, key);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static String encrypt(String alp, String inputStr, String key) {
        String encryptStr = "";
        int j = 0, index1 = 0, index2 = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            index1 = alp.indexOf(inputStr.charAt(i));
            index2 = alp.indexOf(key.charAt(j));
            if (index1 != -1 && index2 != -1) {
                encryptStr += alp.charAt((index1 + index2) % alp.length());
                j = (j + 1) % key.length();
            } else
                encryptStr += inputStr.charAt(i);
        }
        return encryptStr;
    }

    public static String decrypt(String alp, String encryptStr, String key) {
        String decryptStr = "";
        int j = 0, index1 = 0, index2;
        for (int i = 0; i < encryptStr.length(); i++) {
            index1 = alp.indexOf(encryptStr.charAt(i));
            index2 = alp.indexOf(key.charAt(j));
            if (index1 != -1 && index2 != -1) {
                decryptStr += alp.charAt((index1 - index2 + alp.length()) % alp.length());
                j = (j + 1) % key.length();
            } else
                decryptStr += encryptStr.charAt(i);
        }
        return decryptStr;
    }
}