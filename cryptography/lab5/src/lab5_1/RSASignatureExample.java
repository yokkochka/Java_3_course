package lab5_1;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;
import java.util.Base64;

public class RSASignatureExample {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Генерация ключевой пары
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String message = "Hello, this is a secret message!";

        // Подписание сообщения
        byte[] signature = signMessage(message, privateKey);

        // Проверка подписи
        boolean isVerified = verifySignature(message, signature, publicKey);

        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
        System.out.println("Is the signature valid? " + isVerified);
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
}
