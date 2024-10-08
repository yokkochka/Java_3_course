package lab5_1;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String message = "Hello, this is a secret message!";

        byte[] signature = signMessage(message, privateKey);

        boolean isVerified = verifySignature(message, signature, publicKey);

        System.out.println("RSA Signature: " + Base64.getEncoder().encodeToString(signature));
        System.out.println("Is the RSA signature valid? " + isVerified);

        KeyPairGenerator elGamalKeyGen = KeyPairGenerator.getInstance("DSA", "BC");
        elGamalKeyGen.initialize(512);
        KeyPair elGamalPair = elGamalKeyGen.generateKeyPair();

        PrivateKey elGamalPrivateKey = elGamalPair.getPrivate();
        PublicKey elGamalPublicKey = elGamalPair.getPublic();

        byte[] elGamalSignature = signMessageElGamal(message, elGamalPrivateKey);

        boolean isElGamalVerified = verifySignatureElGamal(message, elGamalSignature, elGamalPublicKey);

        System.out.println("ElGamal Signature: " + Base64.getEncoder().encodeToString(elGamalSignature));
        System.out.println("Is the ElGamal signature valid? " + isElGamalVerified);
    }

    public static byte[] signMessage(String message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        return sign.sign();
    }

    public static boolean verifySignature(String message, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initVerify(publicKey);
        sign.update(message.getBytes());
        return sign.verify(signature);
    }

    public static byte[] signMessageElGamal(String message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "BC");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        return sign.sign();
    }

    public static boolean verifySignatureElGamal(String message, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "BC");
        sign.initVerify(publicKey);
        sign.update(message.getBytes());
        return sign.verify(signature);
    }
}