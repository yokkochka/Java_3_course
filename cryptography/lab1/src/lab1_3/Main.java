// Come up with your own monoalphabetic substitution cipher, 
// implement it in any programming language, encrypt an arbitrary 
// message using your cipher, and then decrypt it. 
// Describe the advantages and disadvantages of the cipher.

// Advantages:
//  - simplicity of implementation
//  - use of unique characters
//  - random keys
//  - one character corresponding to multiple characters

// Disadvantages:
//  - simple key generation algorithm
//  - the longer the string, the less efficient the contains method becomes
//  - unreliable

package lab1_3;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();

        String uniqChars = uniqChars(inputStr);
        // System.out.println("uniqChars: " + uniqChars);

        int n = uniqChars.length();
        int[] key = new int[n*3];
        randomFill(key, n);
        // outputArray(key, n*3);
        
        int[] array = new int[inputStr.length()];
        encrypt(array, n, inputStr, uniqChars, key);

        System.out.print("encrypt: ");
        outputArray(array, inputStr.length());

        String decryptStr = decrypt(array, n, uniqChars, key);
        System.out.println("\ndecrypt: " + decryptStr);

        scanner.close();
    }

    public static String uniqChars(String inputStr) {
        String uniqStr = "";
        for (int i = 0; i < inputStr.length(); i++){
            if (uniqStr.indexOf(inputStr.charAt(i)) == -1){
                uniqStr += inputStr.charAt(i);
            }
        }
        return uniqStr;
    }

    public static void randomFill(int[] key, int n){
        Random rnd = new Random();
        int randomValue = 0, flag = 0;;
        for (int i = 0; flag != 1; ){
            randomValue = rnd.nextInt(n*3 - 0 + 1);
            if (contains(key, randomValue, i) == -1){
                key[i] = randomValue; 
                i++;
                if (i == n*3) flag = 1;
            }
        }
    }
    public static void outputArray(int[] array, int n){
        for (int i = 0; i < n; i++){
            System.out.print(array[i]);
        }
    }

    public static int contains(int[] key, int value, int i){
        int result = -1;
        for (int j = 0; j < i; j++){
            if (key[j] == value){
                result = j;
            }
        }
        return result;
    }

    public static void encrypt(int[] array, int n, String inputStr, String uniqChars, int[] key){
        int min = 0, max = min + 2;
        Random rnd = new Random();
        for (int i = 0; i < inputStr.length(); i++){
            min = uniqChars.indexOf(inputStr.charAt(i)) * 3;
            max = min + 2;
            array[i] = key[rnd.nextInt(max - min + 1) + min];
        }
    }

    public static String decrypt(int [] array, int n, String uniqChars, int[] key){
        String decryptStr = "";
        int index = -1;
        for (int i = 0; i < array.length ; i++){
            index = contains(key, array[i], key.length);
            decryptStr += uniqChars.charAt((int)index / 3);
        }
        return decryptStr;
    
    }
}

