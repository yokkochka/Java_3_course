// Task 1
// Design your own transposition cipher, implement it in any programming language,
// encrypt a given message using your cipher, and then decrypt it.
// Describe the advantages and disadvantages of your cipher.

// Advantages:
//  - Simplicity of implementation
//  - The encrypted string looks non-obvious to someone who does not know the encryption method
//  - This code guarantees that the same string will be encrypted in the same way
//  - Because the decryption follows the same principle, it is relatively fast if the key
//  (algorithm) is known

// Disadvantages:
//  - The cipher is too simple and easily susceptible to cryptanalysis
//  - There is no key that could increase the level of complexity
//  - Quadratic complexity O(n**2)
//  - Dependency on the length of the string (depends on the matrix size), auxiliary spaces

package lab1_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine().replace(" ", "");

        String encryptStr = ecrypt(inputStr);
        System.out.println("encrypt: " + encryptStr);

        String decryptStr = decrypt(encryptStr);
        System.out.println("decrypt: " + decryptStr);

        scanner.close();
    }

    public static int sizeMatrix(String str) {
        int n = (int) Math.sqrt(str.length());
        if (n * n < str.length())
            n++;
        return n;
    }

    public static void fillMatrix(char[][] matrix, String inputStr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count < inputStr.length()) {
                    matrix[i][j] = inputStr.charAt(count);
                    count++;
                } else
                    matrix[i][j] = ' ';
            }
        }
    }

    public static void outputMatrix(char[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static String ecrypt(String inputStr) {
        int n = sizeMatrix(inputStr);
        char[][] matrix = new char[n][n];

        fillMatrix(matrix, inputStr, n);
        StringBuilder encryptBuildStr = new StringBuilder();

        int topWall = 0, leftWall = 0, rightWall = n - 1, bottomWall = n - 1;
        int flagMove = 1, i = -1, j = 0;
        for (int k = 0; k < n * n; k++) {
            if (flagMove == 1)
                i++;
            else if (flagMove == 2)
                j++;
            else if (flagMove == 3)
                i--;
            else if (flagMove == 4)
                j--;

            encryptBuildStr.append(matrix[i][j]);

            if (flagMove == 1 && i == bottomWall) {
                flagMove = 2;
                leftWall++;
            } else if (flagMove == 2 && j == rightWall) {
                flagMove = 3;
                bottomWall--;
            } else if (flagMove == 3 && i == topWall) {
                flagMove = 4;
                rightWall--;
            } else if (flagMove == 4 && j == leftWall) {
                flagMove = 1;
                topWall++;
            }
        }
        return encryptBuildStr.toString().replace(" ", "");
    }

    public static String decrypt(String encryptStr) {
        int n = sizeMatrix(encryptStr);
        char[][] matrix = new char[n][n];

        fillMatrix(matrix, encryptStr, n);
        StringBuilder decryptBuildStr = new StringBuilder();

        int topWall = 0, leftWall = 0, rightWall = n - 1, bottomWall = n - 1;
        int flagMove = 1, i = -1, j = 0, count = 0;
        for (int k = 0; k < n * n; k++) {
            if (flagMove == 1)
                i++;
            else if (flagMove == 2)
                j++;
            else if (flagMove == 3)
                i--;
            else if (flagMove == 4)
                j--;
            if (matrix[i][j] != ' ') {
                matrix[i][j] = encryptStr.charAt(count);
                count++;
            }

            if (flagMove == 1 && i == bottomWall) {
                flagMove = 2;
                leftWall++;
            } else if (flagMove == 2 && j == rightWall) {
                flagMove = 3;
                bottomWall--;
            } else if (flagMove == 3 && i == topWall) {
                flagMove = 4;
                rightWall--;
            } else if (flagMove == 4 && j == leftWall) {
                flagMove = 1;
                topWall++;
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                decryptBuildStr.append(matrix[i][j]);
            }
        }
        return decryptBuildStr.toString().replace(" ", "");
    }
}