import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> registeredUsers = new ArrayList<>();

    public UserData() {
        this.registeredUsers = new ArrayList<>();
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public boolean isRegistered(User user) {
        return this.registeredUsers.contains(user);
    }

    public void addUser(User user) {
        this.registeredUsers.add(user);
    }

}