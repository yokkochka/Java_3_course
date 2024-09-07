// Task 2
// Design a simple substitution cipher
// (monoalphabetic cipher), implement it in any programming language,
// encrypt a given message using your cipher, and then decrypt it.

// Advantages:
//  - Simplicity of implementation
//  - Uniqueness of characters
//  - Bidirectional encryption - the encryption algorithm is symmetric
//  - Linear complexity O(n)

// Disadvantages:
//  - The cipher is too simple and easily susceptible to cryptanalysis
//  - There is no key to increase the level of complexity
//  - Shorter strings are more vulnerable, as there are few unique characters

package lab1_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();

        String uniqChars = uniq(inputStr);
        String encryptUniqChars = encryptUniq(uniqChars);

        String encryptStr = encrypt(inputStr, uniqChars, encryptUniqChars);
        System.out.println("encrypt: " + encryptStr);

        String decryptStr = decrypt(encryptStr, uniqChars, encryptUniqChars);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static String uniq(String inputStr) {
        String uniqChars = "";
        for (int i = 0; i < inputStr.length(); i++) {
            if (uniqChars.indexOf(inputStr.charAt(i)) == -1) {
                uniqChars += inputStr.charAt(i);
            }
        }
        return uniqChars;
    }

    public static String encryptUniq(String uniqChars) {
        String encryptUniqChars = "";
        for (int i = uniqChars.length() - 1; i >= 0; i--) {
            encryptUniqChars += uniqChars.charAt(i);
        }
        return encryptUniqChars;
    }

    public static String encrypt(String inputStr, String uniqChars, String encryptUniqChars) {
        String encryptStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            encryptStr += encryptUniqChars.charAt(uniqChars.indexOf(inputStr.charAt(i)));
        }

        return encryptStr;
    }

    public static String decrypt(String encryptStr, String uniqChars, String encryptUniqChars) {
        String decryptStr = "";
        for (int i = 0; i < encryptStr.length(); i++) {
            decryptStr += uniqChars.charAt(encryptUniqChars.indexOf(encryptStr.charAt(i)));
        }
        return decryptStr;
    }
}