package hw;

import java.util.Base64;

public class fn2 {
    // Encrypt password to 128-character ASCII
    public static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) ((c + 6) % 128));
        }
        return encrypted.toString();
    }

    // Build a simple JWT-like token
    public static String buildJwt(String username, String password) {
        /**
         * Fist we create the header
         * 
         * @alg : none
         * @typ : JWT
         */
        String header = "{\"alg\":\"none\",\"typ\":\"JWT\"}";
        System.out.println("Header: " + header);

        String payload = "{\"user\":\"" + username + "\"}"; // username store to json
        System.out.println("Payload: " + payload);
        // for this encrypt pw
        String signature = encryptPassword(password);
        System.out.println("Signature: " + signature);

        // Encode header and payload to Base64 (URL-safe, no padding)
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes());
        // System.out.println("Encoded Header: " + encodedHeader);
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());
        // System.out.println("Encoded Payload: " + encodedPayload);
        String encodedSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(signature.getBytes());
        // System.out.println("Encoded Signature: " + encodedSignature);

        // JWT format: header.payload.signature
        return encodedHeader + "." + encodedPayload + "." + encodedSignature;
    }

    public static void main(String[] args) {
        String username = "student";
        String password = "password123";
        String jwt = buildJwt(username, password);
        System.out.println("Encrypt : " + jwt);
    }
}