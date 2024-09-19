package lab3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter p (prime): ");
        long p = scanner.nextInt();

        System.out.print("Enter q (prime): ");
        long q = scanner.nextInt();

        System.out.println("q and p: " + q + ' ' + p);

        long n = p * q;
        System.out.println("n: " + n);

        long fi_n = (p - 1) * (q - 1);
        System.out.println("fi_n: " + fi_n);

        long e = find_e(fi_n);
        System.err.println("e: " + e);

        long d = find_d(e, fi_n);
        System.out.println("d: " + d);


        System.out.println("private keys: " + e + " " + n);
        System.out.println("public keys: " + d + " " + n);

        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();
        inputStr = scanner.nextLine();

        String encryptStr = encrypt(inputStr, e, n);
        System.out.println("encryptStr: " + encryptStr);

        scanner.close();
    }
    
    public static long find_e(long fi_n){
        long res_e = 0;
        for (int i = 0; i < 10; i++){
            res_e = (int)Math.pow(2, (int)Math.pow(2, i)) + 1;
            if (gcd(res_e, fi_n) == 1){
                return res_e;
            }
        }
        return 0;
    }


    public static long gcd (long a, long b){
        while (b !=0) {
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }


    public static long find_d(long e, long fi_n){
        double d = 0; int i = 1;
        while (true){
            d = (double)((fi_n * i) + 1) / e;
            if (d == (long)d) return (long)d;
            i++;
        }
    }


    public static String encrypt(String inputStr, long e, long n){
        String encryptStr = "";
        long c = Character.getNumericValue(inputStr.charAt(0));
        System.out.println(c);
        c = ((int)Math.pow(c, e)) % n;
        System.out.println(c);



        return encryptStr;
    }



}
