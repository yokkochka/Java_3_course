package lab2_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        char key = 'A';

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

    public static String xorEncryptDecrypt(String inputStr, char key) {
        String resStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            resStr += (char) (inputStr.charAt(i) ^ key);
        }
        return resStr;
    }
}