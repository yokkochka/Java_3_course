package gost;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the string to encrypt: ");
        Scanner scanner = new Scanner(System.in);
        String startInputString = scanner.nextLine();
        
        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        while (key.length() < 4) {
            System.out.print("Enter the key (minimum 4 characters): ");
            key = scanner.nextLine();
        }

        scanner.close();
        key = key.substring(0, 4);

        Map<Character, String> charToBin = new HashMap<>();
        Map<String, Integer> binToInt = new HashMap<>();
        Map<Integer, int[]> intToInt = new HashMap<>();

        fillDictCharToBin(charToBin, binToInt, intToInt);

        int dop =  0;
        if (startInputString.length() % 8 == 0) dop = 0;
        else dop = 8 - startInputString.length() % 8;
        for (int i = 0; i < dop; i++) {
            startInputString += " ";
        }
        
        // System.out.println(dop + " " + startInputString.length());


        String inputString = "";

        while (startInputString.length() > 0){
            
            inputString = startInputString.substring(0, 8);
            startInputString = startInputString.substring(8, startInputString.length());

            String binString = "";
            for (char c : inputString.toCharArray()) {
                if (charToBin.containsKey(c)) {
                    binString += charToBin.get(c);
                } else {
                    throw new IllegalArgumentException("Character not found in map: " + c);
                }
            }

            String x0String = "";
            for (char c : key.toCharArray()) {
                if (charToBin.containsKey(c)) {
                    x0String += charToBin.get(c);
                } else {
                    throw new IllegalArgumentException("Character not found in map: " + c);
                }
            }
            System.out.println("String to encrypt: " + inputString);
            System.out.println("The first 4 bits of the key for the first cycle: " + key);

            // System.out.println("Binary string: " + binString.toString());
            // System.out.println("Binary string: " + x0String.toString());

            String l0String = binString.substring(0, 32);
            String r0String = binString.substring(32, 64);

            String mod2_32 = summaMod2_32(r0String, x0String);
            // System.out.println("mod2_32: " + mod2_32);

            String fR0X0 = "";

            int j = 0;
            for (int i = 8; i > 0; i--){
                j = binToInt.get(mod2_32.substring(0, 4));
                mod2_32 = mod2_32.substring(4, mod2_32.length());
                fR0X0 += intToBinString(binToInt, intToInt.get(i)[j]);
            }

            // System.out.println("Substitution: " + fR0X0);

            fR0X0 = fR0X0.substring(11, fR0X0.length()) + fR0X0.substring(0, 11);
            // System.out.println("Circle: " + fR0X0);

            String r1String = xor(l0String, fR0X0);
            // System.out.println("r1: " + r1String);

            System.out.println("Encrypted string(L1 + R1): " + r0String + r1String);
        }

    }

    public static String xor(String a, String b){
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result += "0";
            } else {
                result += "1";
            }
        }
        return result;
    }

    public static String intToBinString (Map<String, Integer> map, Integer value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; 
    }
    
    public static String summaMod2_32(String a, String b) {
        String result = "";
        int mind = 0;
        for (int i = a.length()-1; i >= 0; i--) {
            if (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + mind == 0) {
                result = "0" + result;
                mind = 0;
            } else if (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + mind == 1) {
                result = "1" + result;
                mind = 0;
            } else if (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + mind == 2) {
                result = "0" + result;
                mind = 1;
            } else if (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + mind == 3) {
                result = "1" + result;
                mind = 1;
            }
        }
        return result;
    }
    

    private static void fillDictCharToBin(Map<Character, String> charToBin, Map<String, Integer> binToInt, Map<Integer, int[]> intToInt) {
        charToBin.put('А', "11000000");
        charToBin.put('Б', "11000001");
        charToBin.put('В', "11000010");
        charToBin.put('Г', "11000011");
        charToBin.put('Д', "11000100");
        charToBin.put('Е', "11000101");
        charToBin.put('Ж', "11000110");
        charToBin.put('З', "11000111");
        charToBin.put('И', "11001000");
        charToBin.put('Й', "11001001");
        charToBin.put('К', "11001010");
        charToBin.put('Л', "11001011");
        charToBin.put('М', "11001100");
        charToBin.put('Н', "11001101");
        charToBin.put('О', "11001110");
        charToBin.put('П', "11001111");
        charToBin.put('Р', "11010000");
        charToBin.put('С', "11010001");
        charToBin.put('Т', "11010010");
        charToBin.put('У', "11010011");
        charToBin.put('Ф', "11010100");
        charToBin.put('Х', "11010101");
        charToBin.put('Ц', "11010110");
        charToBin.put('Ч', "11010111");
        charToBin.put('Ш', "11011000");
        charToBin.put('Щ', "11011001");
        charToBin.put('Ъ', "11011010");
        charToBin.put('Ы', "11011011");
        charToBin.put('Ь', "11011100");
        charToBin.put('Э', "11011101");
        charToBin.put('Ю', "11011110");
        charToBin.put('Я', "11011111");
        
        charToBin.put('а', "11100000");
        charToBin.put('б', "11100001");
        charToBin.put('в', "11100010");
        charToBin.put('г', "11100011");
        charToBin.put('д', "11100100");
        charToBin.put('е', "11100101");
        charToBin.put('ж', "11100110");
        charToBin.put('з', "11100111");
        charToBin.put('и', "11101000");
        charToBin.put('й', "11101001");
        charToBin.put('к', "11101010");
        charToBin.put('л', "11101011");
        charToBin.put('м', "11101100");
        charToBin.put('н', "11101101");
        charToBin.put('о', "11101110");
        charToBin.put('п', "11101111");
        charToBin.put('р', "11110000");
        charToBin.put('с', "11110001");
        charToBin.put('т', "11110010");
        charToBin.put('у', "11110011");
        charToBin.put('ф', "11110100");
        charToBin.put('х', "11110101");
        charToBin.put('ц', "11110110");
        charToBin.put('ч', "11110111");
        charToBin.put('ш', "11111000");
        charToBin.put('щ', "11111001");
        charToBin.put('ъ', "11111010");
        charToBin.put('ы', "11111011");
        charToBin.put('ь', "11111100");
        charToBin.put('э', "11111101");
        charToBin.put('ю', "11111110");
        charToBin.put('я', "11111111");
        charToBin.put(' ', "00010000");

        binToInt.put("0000", 0);
        binToInt.put("0001", 1);    
        binToInt.put("0010", 2);
        binToInt.put("0011", 3);
        binToInt.put("0100", 4);
        binToInt.put("0101", 5);
        binToInt.put("0110", 6);
        binToInt.put("0111", 7);
        binToInt.put("1000", 8);
        binToInt.put("1001", 9);
        binToInt.put("1010", 10);
        binToInt.put("1011", 11);
        binToInt.put("1100", 12);
        binToInt.put("1101", 13);
        binToInt.put("1110", 14);
        binToInt.put("1111", 15);

        intToInt.put(8, new int[]{1,15,13,0,5,7,10,4,9,2,3,14,6,11,8,12});
        intToInt.put(7, new int[]{13,11,4,1,3,15,5,9,0,10,14,7,6,8,2,12});
        intToInt.put(6, new int[]{4,11,10,0,7,2,1,13,3,6,8,5,9,12,15,14});
        intToInt.put(5, new int[]{6,12,7,1,5,15,13,8,4,10,9,14,0,3,11,2});
        intToInt.put(4, new int[]{7,13,10,1,0,8,9,15,14,4,6,12,11,2,5,3});
        intToInt.put(3, new int[]{5,8,1,13,10,3,4,2,14,15,12,7,6,0,9,11});
        intToInt.put(2, new int[]{14,11,4,12,6,13,15,10,2,3,8,1,0,7,5,9});
        intToInt.put(1, new int[]{4,10,9,2,13,8,0,14,6,11,1,12,7,15,5,3});

        
    }


}

