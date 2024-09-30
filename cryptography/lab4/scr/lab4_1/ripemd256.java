package lab4_1;

public class ripemd256 {
    public static String hash(String input) {
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("RIPEMD256");
            byte[] hashBytes = digest.digest(input.getBytes());
            return new String(org.bouncycastle.util.encoders.Hex.encode(hashBytes));
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("RIPEMD256 algorithm not found", e);
        }
    }

    public static String hashFromFile(String filePath) {
        try {
            String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));
            return hash(content);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }


}
