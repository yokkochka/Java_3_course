// Implement your own version of the ROT13 function in any programming language.
// Encrypt a message using your cipher, and then decrypt it.
// Describe the advantages and disadvantages of the cipher.

// Advantages:
//  - Simplicity of implementation
//  - Symmetry
//  - Fast processing

// Disadvantages:
//  - Vulnerable to frequency analysis
//  - Encrypts only alphabetic characters, not all symbols
//  - Uses a weak key
//  - Not secure

package lab1_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();

        String alp = "abcdefghijklmnopqrstuvwxyz";
        String encryptStr = encryptAndDecrypt(inputStr, alp, 13);
        System.out.println("encrypt: " + encryptStr);

        String decrypt = encryptAndDecrypt(encryptStr, alp, 13);
        System.out.println("decrypt: " + decrypt);

        scanner.close();
    }

    public static String encryptAndDecrypt(String startString, String alp, int k) {
        String endString = "";
        for (int i = 0; i < startString.length(); i++) {
            if (alp.indexOf(startString.charAt(i)) != -1) {
                endString += alp.charAt((alp.indexOf(startString.charAt(i)) + k) % alp.length());
            } else
                endString += startString.charAt(i);
        }
        return endString;
    }
}
