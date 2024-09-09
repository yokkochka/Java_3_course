package lab2_2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine().toLowerCase();
        
        String alp = "фбвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        String key = randomKeyString(alp, inputStr.length());
        System.out.println("key: " + key);

        String encryptStr = encrypt(alp, inputStr, key);
        System.out.println("encrypt: " + encryptStr);

        String decryptStr = decrypt(alp, encryptStr, key);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static String randomKeyString(String alp, int n) {
        String key = "";
        Random rnd = new Random();
        int random = 0;
        for (int i = 0; i < n; i++) {
            random = rnd.nextInt(n);
            key += alp.charAt(random);
        }
        return key;
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