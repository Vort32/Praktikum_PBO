import java.util.ArrayList;

public class Login {
    private String username;
    private String password;
    private boolean isAdmin;
    private static ArrayList<Login> logins = new ArrayList<>();

    public Login(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        logins.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // Overloading 
    public static boolean authenticate(String username, String password) {
        Login login = getLoginByUsername(username);
        return login != null && login.password.equals(password);
    }
    
    // Overloaded 
    public static boolean authenticate(Login login, String password) {
        return login != null && login.password.equals(password);
    }

    public static boolean isAdmin(String username) {
        Login login = getLoginByUsername(username);
        return login != null && login.isAdmin();
    }

    public static Login getLoginByUsername(String username) {
        for (Login login : logins) {
            if (login.username.equals(username)) {
                return login;
            }
        }
        return null;
    }
    
    // Overriding 
    @Override
    public String toString() {
        return "Username: " + username + ", isAdmin: " + isAdmin;
    }
}
