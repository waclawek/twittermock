package infrastructure.passwordMenagment;

public class PasswordHashing implements PasswordHash {
    private static final String hash = "1236hashhash";

    @Override
    public String passwordHash(String password) {
        String newPassword = password + hash;
        return newPassword;
    }

}
