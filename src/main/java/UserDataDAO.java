import java.util.List;

public interface UserDataDAO {
    List<String> getAllUsers();

    UserData getUserById(int id);

    List<UserData> getAllUsersRole(String role);

    void updateUser(UserData id);

    void createUser(UserData user);

    void deleteUser(UserData id);
}
