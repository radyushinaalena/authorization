import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException, Exception {
        UserDataDAO userDataDAO = new ServiceUserDataDAO();

        UserData userData = new UserData("fff", "ffsss", "alsdflsdk");
        ArrayList<String> list = new ArrayList<>();
        list.add(UserData.getRoles().get(1));
        list.add(UserData.getRoles().get(2));
        UserData userData1 = new UserData("2444", "326346", "-08-2j", list);

        System.out.println(userDataDAO.getAllUsers());
        System.out.println(userDataDAO.getUserById(8));
        System.out.println(userDataDAO.getAllUsersRole("Дизайнер"));
        userDataDAO.updateUser(userDataDAO.getUserById(9));
        userDataDAO.createUser(userData);
        userDataDAO.createUser(userData1);
        userDataDAO.deleteUser(userDataDAO.getUserById(2));
        System.out.println(userDataDAO.getAllUsers());

    }
}
