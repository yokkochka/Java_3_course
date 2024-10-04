package hash;

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
        // System.out.println("e: " + e);

        System.out.println("private keys: " + d + " " + n);
        System.out.println("public keys: " + e + " " + n);

        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();
        inputStr = scanner.nextLine().toUpperCase();

        String alf = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        System.out.print("Enter h0: ");
        BigInteger h0 = scanner.nextBigInteger();

        BigInteger hash = hash(inputStr, h0, n, alf);
        System.out.println("hash: " + hash);

        scanner.close();
    }

    public static BigInteger hash(String inputStr, BigInteger h0, BigInteger n, String alf) {
        BigInteger hash = h0;
        for (int i = 0; i < inputStr.length(); i++) {
            hash =
                ((hash.add(BigInteger.valueOf(alf.indexOf(inputStr.charAt(i)) + 1))).pow(2)).mod(n);
        }
        return hash;
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
}
