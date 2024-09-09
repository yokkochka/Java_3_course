package lab2_3;

import java.io.StringReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine().toLowerCase();
        
        String alp = "abcdefghujklmnopqrstuvwxyz";

        String key = randomKeyString(alp, inputStr.length());
        System.out.println("key: " + key);

        key = stringToBits(key);
        inputStr = stringToBits(inputStr);

        System.out.println("bitsKey: " + key);
        System.out.println("bitsInputStr: " + inputStr);

        System.out.println("len bitsKey: " + key.length());
        System.out.println("len bitsInputStr: " + inputStr.length());

        String encryptStr = encrypt(inputStr, key);
        System.out.println("encrypt: " + encryptStr);
        
        encryptStr = bitsToString(encryptStr);
        System.out.println("encrypt: " + encryptStr);


        // String decryptStr = decrypt(alp, encryptStr, key);
        // System.out.println("decrypt: " + decryptStr);

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

    public static String stringToBits(String str) {
        StringBuilder bitsStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            bitsStr.append(String.format("%8s", Integer.toBinaryString(str.charAt(i))).replace(' ', '0'));
        }
        return bitsStr.toString();
    }

    public static String bitsToString(String bits) {
        StringBuilder stringStr = new StringBuilder();
        for (int i = 0; i < bits.length(); i += 8) {
            String byteStr = bits.substring(i, i + 8);
            stringStr.append((char) Integer.parseInt(byteStr, 2));
        }
        return stringStr.toString();
    }


    public static String encrypt (String inputStr, String key){
        String encryptStr = "";
        for (int i = 0; i < inputStr.length(); i++){
            encryptStr += (inputStr.charAt(i) == key.charAt(i)) ? '0' : '1';
        }
        return encryptStr;
    }

}