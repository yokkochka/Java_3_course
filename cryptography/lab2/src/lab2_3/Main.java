package lab2_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();

        String key = randomKeyString("abcdefghijklmnopqrstuvwxyz", inputStr.length());
        System.out.println("key strning: " + key);

        String encryptStr = xorEncryptDecrypt(inputStr, key);
        System.out.println("encrypt: " + encryptStr);

        String decrypted = xorEncryptDecrypt(encryptStr, key);
        System.out.println("decrypt: " + decrypted);

        try (FileWriter writer = new FileWriter("test.txt", false)) {
            writer.write(encryptStr);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }

    public static String xorEncryptDecrypt(String inputStr, String key) {
        String resStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            resStr += (char) (inputStr.charAt(i) ^ key.charAt(i));
        }
        return resStr;
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
}