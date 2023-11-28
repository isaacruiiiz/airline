import java.util.ArrayList;

public class Users {
    private String username;
    private String password;
    private boolean isAdmin;

    public Users(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static ArrayList<Users> users() {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("admin", "admin", true));
        users.add(new Users("user1", "password1", false));
        return users;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
