import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

public class ServiceUserDataDAO extends UserData implements UserDataDAO {
    @Override
    public List<String> getAllUsers() {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e.id,e.name,e.login,e.password,e.datecreateprofile,e.dateupdateprofile from UserData e order by e.id";
        List<Object[]> query = entityManager.createQuery(jpqlQuery, Object[].class).getResultList();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < query.size(); i++) {
            String q = Arrays.toString(query.get(i));
            strings.add(q);
        }
        entityManager.getTransaction().commit();
        return strings;

    }

    @Override
    public UserData getUserById(int id) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from UserData e where e.id= :id order by e.id";

        TypedQuery<UserData> query = entityManager.createQuery(jpqlQuery, UserData.class);

        // Устанавливаем значение параметра minAge в запросе
        query.setParameter("id", id);

        // Выполняем запрос и получаем результат в виде списка студентов
        UserData userData = query.getSingleResult();

        // Завершаем транзакцию
        entityManager.getTransaction().commit();
        return userData;
    }

    @Override
    public List<UserData> getAllUsersRole(String role) {

        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from UserData e where e.role like :role order by e.id";

        TypedQuery<UserData> query = entityManager.createQuery(jpqlQuery, UserData.class);

        // Устанавливаем значение параметра minAge в запросе
        query.setParameter("role", "%" + role + "%");

        // Выполняем запрос и получаем результат в виде списка студентов
        // UserData userData = query.getSingleResult();

        // Завершаем транзакцию
        List<UserData> userDataList = query.getResultList();

        entityManager.getTransaction().commit();
        return userDataList;
    }

    @Override
    public void updateUser(UserData id) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        System.out.println("Выберите роль указав id");
        List<String> newRole = new ArrayList<>();
        while (true) {
            ;
            for (int i = 0; i < UserData.getRoles().size(); i++) {
                System.out.println((i) + " - " + UserData.getRoles().get(i));
            }
            int role = scanner.nextInt();

            if (role == 888) {
                break;
            } else {
                newRole.add(UserData.getRoles().get(role));
                System.out.println("Роль добавлена. Укажите дополнительную роль или введите \"888\" для завершения редактирования");

            }

        }
        id.setRole(newRole.toString());
        id.setName(name);
        id.setLogin(login);
        id.setPassword(password);
        id.setUpdateDate(new Date());
        entityManager.merge(id);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void createUser(UserData user) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUser(UserData id) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from UserData e where e.id= :id";

        TypedQuery<UserData> query = entityManager.createQuery(jpqlQuery, UserData.class);

        query.setParameter("id", id.getId());

        List<UserData> employeeList = query.getResultList();

        entityManager.remove(employeeList.get(0));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
