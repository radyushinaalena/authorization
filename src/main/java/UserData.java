import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userdata")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "datecreateprofile")
    private Date datecreateprofile;
    @Column(name = "dateupdateprofile")
    private Date dateupdateprofile;
    private static List<String> roles = Arrays.asList("Разработчик", "Аналитик", "Тестировщик", "Менеджер", "Дизайнер", "По умолчанию");
    @Column(name = "role",columnDefinition = "По умолчанию")
    private String role;

    public UserData(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.datecreateprofile = new Date();
        this.dateupdateprofile = null;
        this.role = roles.get(5);
    }

    public UserData(String name, String login, String password, ArrayList<String> role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.datecreateprofile = new Date();
        this.dateupdateprofile = null;
        this.role = role.toString();
    }

    public UserData() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return datecreateprofile;
    }

    public void setCreateDate(Date createDate) {
        this.datecreateprofile = createDate;
    }

    public Date getUpdateDate() {
        return dateupdateprofile;
    }

    public void setUpdateDate(Date updateDate) {
        this.dateupdateprofile = updateDate;
    }

    public static List<String> getRoles() {
        return roles;
    }

    public static void setRoles(List<String> roles) {
        UserData.roles = roles;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + datecreateprofile +
                ", updateDate=" + dateupdateprofile +
                ", role='" + role + '\''+
                '}'+" \n";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
