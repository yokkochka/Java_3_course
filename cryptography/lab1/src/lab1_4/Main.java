// Come up with a polygram substitution cipher, implement it in any programming language,
// encrypt a random message using your cipher, and then decrypt it.
// Describe the advantages and disadvantages of the cipher.

// Advantages:
//  - simplicity of implementation
//  - splitting into groups makes the cipher more robust compared to a monoalphabetic substitution
//  cipher
//  - random keys
//  - different group lengths

// Disadvantages:
//  - possible redundancy, as the length of the encrypted string is the same or longer than the
//  original
//  - less efficient with large amounts of data due to the containsValue() method

package lab1_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();

        int lenGroup = minLenGroup(inputStr.length());

        Map<String, String> map = new HashMap<>();
        fillDict(map, inputStr, lenGroup);

        System.out.println("Group encryption table: ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encryptStr = encrypt(inputStr, map, lenGroup);
        System.out.println("encrypt: " + encryptStr);

        String decryptStr = decrypt(encryptStr, map, lenGroup);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static int minLenGroup(int len) {
        for (int i = 2; i <= len; i++) {
            if (len % i == 0)
                return i;
        }
        return 0;
    }

    public static void fillDict(Map<String, String> map, String inputStr, int lenGroup) {
        String encrypt, decrypt;
        String alp = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();

        for (int i = 0; i < inputStr.length(); i += lenGroup) {
            encrypt = "";
            decrypt = "";

            int actualLen = Math.min(lenGroup, inputStr.length() - i);

            for (int j = 0; j < actualLen; j++) {
                decrypt += inputStr.charAt(i + j);
                encrypt += alp.charAt(rand.nextInt(alp.length()));
            }

            if (!encrypt.equals(decrypt) && !map.containsValue(encrypt)) {
                map.put(decrypt, encrypt);
            } else {
                i -= lenGroup;
            }
        }
    }

    public static String encrypt(String inputStr, Map<String, String> map, int lenGroup) {
        String encryptStr = "", inputSubStr;

        for (int i = 0; i < inputStr.length(); i += lenGroup) {
            int actualLen = Math.min(lenGroup, inputStr.length() - i);
            inputSubStr = "";
            for (int j = 0; j < actualLen; j++) {
                inputSubStr += inputStr.charAt(i + j);
            }
            if (map.get(inputSubStr) != null)
                encryptStr += map.get(inputSubStr);
        }

        return encryptStr;
    }

    public static String decrypt(String encryptStr, Map<String, String> map, int lenGroup) {
        String decryptStr = "", encryptSubStr;

        for (int i = 0; i < encryptStr.length(); i += lenGroup) {
            int actualLen = Math.min(lenGroup, encryptStr.length() - i);
            encryptSubStr = "";
            for (int j = 0; j < actualLen; j++) {
                encryptSubStr += encryptStr.charAt(i + j);
            }
            if (map.containsValue(encryptSubStr)) {
                decryptStr += find(map, encryptSubStr);
            }
        }
        return decryptStr;
    }

    public static String find(Map<String, String> map, String encryptSubStr) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(encryptSubStr)) {
                return entry.getKey();
            }
        }
        return "";
    }
}