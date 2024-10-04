package digital_signature;

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

        System.out.print("Enter hash function: ");
        BigInteger hash_function = scanner.nextBigInteger();

        BigInteger s = digital_signature(hash_function, e, n);
        System.err.println("Digital signature: " + s);

        BigInteger has_function_restored = has_function_restored(s, d, n);
        System.out.println("Restored hash function: " + has_function_restored);

        scanner.close();
    }

    public static BigInteger digital_signature(BigInteger hash_function, BigInteger e, BigInteger n) {
        return hash_function.pow(e.intValue()).mod(n);
    }

    public static BigInteger has_function_restored(BigInteger s, BigInteger d, BigInteger n) {
        return s.pow(d.intValue()).mod(n);
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
