package lab4_1;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class gost3411 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("GOST3411");
            byte[] hashBytes = digest.digest(input.getBytes());
            return new String(Hex.encode(hashBytes));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("GOST3411 algorithm not found", e);
        }
    }

    public static String hashFromFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return hash(content);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }
    
}