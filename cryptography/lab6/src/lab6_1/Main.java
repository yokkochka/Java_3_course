package lab6_1;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageHash = md.digest(message.getBytes());
        System.out.println("1. MD5 хеш сообщения: " + Base64.getEncoder().encodeToString(messageHash));

        KeyPairGenerator dsaKeyGen = KeyPairGenerator.getInstance("DSA", "BC");
        dsaKeyGen.initialize(1024);
        KeyPair dsaKeyPair = dsaKeyGen.generateKeyPair();

        byte[] dsaSignature = signMessageDSA(message, dsaKeyPair.getPrivate());
        System.out.println("2. Подпись сообщения (DSA): " + Base64.getEncoder().encodeToString(dsaSignature));

        KeyGenerator desKeyGen = KeyGenerator.getInstance("DES");
        SecretKey desKey = desKeyGen.generateKey();

        Cipher desCipher = Cipher.getInstance("DES");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] encryptedSignature = desCipher.doFinal(dsaSignature);
        System.out.println("3. Зашифрованная подпись (DES): " + Base64.getEncoder().encodeToString(encryptedSignature));

        desCipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decryptedSignature = desCipher.doFinal(encryptedSignature);
        System.out.println("4. Расшифрованная подпись (DES): " + Base64.getEncoder().encodeToString(decryptedSignature));

        boolean isVerified = verifySignatureDSA(message, decryptedSignature, dsaKeyPair.getPublic());
        System.out.println("5. Проверка подписи (валидна?): " + isVerified);

        scanner.close();
    }

    public static byte[] signMessageDSA(String message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "BC");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        return sign.sign();
    }

    public static boolean verifySignatureDSA(String message, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "BC");
        sign.initVerify(publicKey);
        sign.update(message.getBytes());
        return sign.verify(signature);
    }
}
