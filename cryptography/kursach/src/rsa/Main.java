package rsa;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter p (prime): ");
        BigInteger p = scanner.nextBigInteger();

        System.out.print("Enter q (prime): ");
        BigInteger q = scanner.nextBigInteger();

        BigInteger n = p.multiply(q);
        // System.out.println("n: " + n);

        BigInteger fi_n =
            p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        // System.out.println("fi_n: " + fi_n);

        BigInteger d = find_d(fi_n);
        // System.err.println("d: " + d);

        BigInteger e = find_e(d, fi_n);
        // System.out.println("e: " + e);`

        System.out.println("private keys: " + d + " " + n);
        System.out.println("public keys: " + e + " " + n);

        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();
        inputStr = scanner.nextLine().toUpperCase();

        String alf = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        BigInteger[] encryptStr = new BigInteger[inputStr.length()];
        encrypt(inputStr, e, n, encryptStr, alf);

        System.out.print("encrypt: ");
        for (int i = 0; i < inputStr.length(); i++) {
            System.out.print(encryptStr[i]);
        }

        System.out.println();
        String decryptStr = decrypt(encryptStr, d, n, alf);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static BigInteger find_d(BigInteger fi_n) {
        BigInteger res_d = BigInteger.valueOf(0);
        for (int i = 2; i < 10; i++) {
            res_d = BigInteger.valueOf(i);
            if (gcd(res_d, fi_n).compareTo(BigInteger.valueOf(1)) == 0) {
                return res_d;
            }
        }
        return BigInteger.valueOf(0);
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (b.compareTo(BigInteger.valueOf(0)) != 0) {
            BigInteger tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
    }

    public static BigInteger find_e(BigInteger d, BigInteger fi_n) {
        int i = 1;
        while (true) {
            BigInteger e = fi_n.multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(1));
            if (d.compareTo(BigInteger.valueOf(0)) != 0
                && (e.mod(d)).compareTo(BigInteger.valueOf(0)) == 0) {
                return e.divide(d);
            }
            i++;
        }
    }

    public static void encrypt(
        String inputStr, BigInteger e, BigInteger n, BigInteger[] encryptStr, String alf) {
        for (int i = 0; i < inputStr.length(); i++) {
            BigInteger c =
                BigInteger.valueOf(alf.indexOf(inputStr.charAt(i))).add(BigInteger.valueOf(1));
            c = c.pow(e.intValue());
            c = c.mod(n);
            encryptStr[i] = c;
        }
    }

    public static String decrypt(BigInteger[] encryptStr, BigInteger d, BigInteger n, String alf) {
        String decryptStr = "";
        for (int i = 0; i < encryptStr.length; i++) {
            BigInteger c = encryptStr[i].pow(d.intValue()).subtract(BigInteger.valueOf(1));
            c = c.mod(n);
            decryptStr += alf.charAt(c.intValue());
        }
        return decryptStr;
    }
}
