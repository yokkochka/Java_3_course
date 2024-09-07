// It is known that the message "Pbatenghyngvbaf! Vg'f n Pnrfne pvcure!"
// was encrypted using a Caesar cipher, but the key k is unknown.
// Write a helper program to assist in decrypting this message.

// Answer: k = 20 -> "congratulations! it's a caesar cipher!"

package lab1_6;

public class Main {
    public static void main(String[] args) {
        String inputStr = "Pbatenghyngvbaf! Vg'f n Pnrfne pvcure!".toLowerCase();
        String alp = "abcdefghijklmnopqrstuvwxyz";
        String decryptStr = "";
        for (int k = 1; k < alp.length(); k++) {
            decryptStr = "";
            System.out.print("if k = " + k);
            for (int j = 0; j < inputStr.length(); j++) {
                if (alp.indexOf(inputStr.charAt(j)) != -1) {
                    decryptStr += alp.charAt((inputStr.charAt(j) + k) % 26);
                } else
                    decryptStr += inputStr.charAt(j);
            }
            System.out.print(" decryptStr = " + decryptStr + "\n");
        }
    }
}
