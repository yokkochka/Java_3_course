package lab4_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main { 
    public static void main(String[] args) {
        String input_str1 = "Hello world!";

        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        input_str1 = "Hello world";
        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        input_str1 = "Hello, world!";
        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        input_str1 = "Hello world!!";
        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();


        input_str1 = "";
        System.out.println(String.format("%-15s| %s", "Input string", input_str1));
        System.out.println(String.format("%-15s| %s", "GOST3411", gost3411.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD320", ripemd320.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "MD5", md5.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-256", sha256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD128", ripemd128.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD160", ripemd160.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-512", sha512.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-384", sha384.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "RIPEMD256", ripemd256.hash(input_str1)));
        System.out.println(String.format("%-15s| %s", "SHA-224", sha224.hash(input_str1)));
        System.out.println();

        try {
            String inputFilePath = "cryptography/lab4/scr/lab4_1/file_1_mb.txt";

            String[] hashFunctions = {"GOST3411", "RIPEMD320", "MD5", "SHA-256", "RIPEMD128", "RIPEMD160", "SHA-512", "SHA-384", "RIPEMD256", "SHA-224"};
            StringBuilder allHashResults = new StringBuilder();
        
            for (int i = 0; i < hashFunctions.length; i++) {
                String hashResult = "";
                switch (hashFunctions[i]) {
                    case "GOST3411":
                        hashResult = gost3411.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD320":
                        hashResult = ripemd320.hashFromFile(inputFilePath);
                        break;
                    case "MD5":
                        hashResult = md5.hashFromFile(inputFilePath);
                        break;
                    case "SHA-256":
                        hashResult = sha256.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD128":
                        hashResult = ripemd128.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD160":
                        hashResult = ripemd160.hashFromFile(inputFilePath);
                        break;
                    case "SHA-512":
                        hashResult = sha512.hashFromFile(inputFilePath);
                        break;
                    case "SHA-384":
                        hashResult = sha384.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD256":
                        hashResult = ripemd256.hashFromFile(inputFilePath);
                        break;
                    case "SHA-224":
                        hashResult = sha224.hashFromFile(inputFilePath);
                        break;
                }
                allHashResults.append(hashFunctions[i]).append(": ").append(hashResult).append("\n");
            }
        
            String outputFilePath =  "cryptography/lab4/scr/output/test3.txt";
            Files.write(Paths.get(outputFilePath), allHashResults.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String inputFilePath = "cryptography/lab4/scr/lab4_1/file1_3_mb.txt";
        
            String[] hashFunctions = {"GOST3411", "RIPEMD320", "MD5", "SHA-256", "RIPEMD128", "RIPEMD160", "SHA-512", "SHA-384", "RIPEMD256", "SHA-224"};
            StringBuilder allHashResults = new StringBuilder();
        
            for (int i = 0; i < hashFunctions.length; i++) {
                String hashResult = "";
                switch (hashFunctions[i]) {
                    case "GOST3411":
                        hashResult = gost3411.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD320":
                        hashResult = ripemd320.hashFromFile(inputFilePath);
                        break;
                    case "MD5":
                        hashResult = md5.hashFromFile(inputFilePath);
                        break;
                    case "SHA-256":
                        hashResult = sha256.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD128":
                        hashResult = ripemd128.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD160":
                        hashResult = ripemd160.hashFromFile(inputFilePath);
                        break;
                    case "SHA-512":
                        hashResult = sha512.hashFromFile(inputFilePath);
                        break;
                    case "SHA-384":
                        hashResult = sha384.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD256":
                        hashResult = ripemd256.hashFromFile(inputFilePath);
                        break;
                    case "SHA-224":
                        hashResult = sha224.hashFromFile(inputFilePath);
                        break;
                }
                allHashResults.append(hashFunctions[i]).append(": ").append(hashResult).append("\n");
            }
        
            String outputFilePath = "cryptography/lab4/scr/output/test4.txt";
            Files.write(Paths.get(outputFilePath), allHashResults.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String inputFilePath = "cryptography/lab4/scr/lab4_1/file_10_mb.txt";
        
            String[] hashFunctions = {"GOST3411", "RIPEMD320", "MD5", "SHA-256", "RIPEMD128", "RIPEMD160", "SHA-512", "SHA-384", "RIPEMD256", "SHA-224"};
            StringBuilder allHashResults = new StringBuilder();
        
            for (int i = 0; i < hashFunctions.length; i++) {
                String hashResult = "";
                switch (hashFunctions[i]) {
                    case "GOST3411":
                        hashResult = gost3411.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD320":
                        hashResult = ripemd320.hashFromFile(inputFilePath);
                        break;
                    case "MD5":
                        hashResult = md5.hashFromFile(inputFilePath);
                        break;
                    case "SHA-256":
                        hashResult = sha256.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD128":
                        hashResult = ripemd128.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD160":
                        hashResult = ripemd160.hashFromFile(inputFilePath);
                        break;
                    case "SHA-512":
                        hashResult = sha512.hashFromFile(inputFilePath);
                        break;
                    case "SHA-384":
                        hashResult = sha384.hashFromFile(inputFilePath);
                        break;
                    case "RIPEMD256":
                        hashResult = ripemd256.hashFromFile(inputFilePath);
                        break;
                    case "SHA-224":
                        hashResult = sha224.hashFromFile(inputFilePath);
                        break;
                }
                allHashResults.append(hashFunctions[i]).append(": ").append(hashResult).append("\n");
            }
        
            String outputFilePath = "cryptography/lab4/scr/output/test5.txt";
            Files.write(Paths.get(outputFilePath), allHashResults.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}









