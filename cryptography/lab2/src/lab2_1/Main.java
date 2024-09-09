package lab2_1;

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

        scanner.close();
    }

    public static String xorEncryptDecrypt(String inputStr, char key) {
        String resStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            resStr += (char) (inputStr.charAt(i) ^ key);
        }
        return resStr;
    }



    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
        
    //     String key = "key";

    //     // Первые 2 буквы при шифровании privet и ключа key
    //     char p = 'p';
    //     char k = 'k';
    //     char a = (char)(p ^ k);

    //     System.out.println("p: " + p + ", int: " + (int)p);
    //     System.out.println("k: " + k + ", int: " + (int)k);
    //     System.out.println("a: " + a + ", int: " + (int)a); // должно быть 27



    //     System.out.print("input your string: ");
    //     String inputStr = scanner.nextLine();
    //     System.out.println("entered string: " + inputStr);

    //     String encryptedStr = encrypt(inputStr, key);
    //     System.out.println("encrypted string: " + encryptedStr);

    //     String decryptedStr = decrypt(encryptedStr, key);
    //     System.out.println("decrypted string: " + decryptedStr);

    // }

    // public static String encrypt(String inputStr, String key){
    //     String encryptedStr = "";

    //     for(int i = 0; i < inputStr.length(); i++){
    //         char p = inputStr.charAt(i);
    //         char k = key.charAt(i % key.length());
    //         encryptedStr += (char)(p ^ k);
    //         System.out.println((int)(p^k));
    //     }

    //     return encryptedStr;
    // }

    // public static String decrypt(String inputStr, String key){
    //     String decryptedStr = "";

    //     for(int i = 0; i < inputStr.length(); i++){
    //         char c = inputStr.charAt(i);
    //         char k = key.charAt(i % key.length());
    //         decryptedStr += (char)(c ^ k);
    //     }

    //     return decryptedStr;
    // }


}