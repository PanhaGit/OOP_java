package func;

public class fun_lib {

    public static void encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + 10));
        }
        System.out.println("Encrypted Password: " + encrypted);
    }

    public static void main(String[] args) {
        String pw = "password123";

        encryptPassword(pw);
    }
}
