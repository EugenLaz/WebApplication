package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<UserRole> userRoles = new ArrayList<>();
    private String email;
    private String name;
    private String password;
    private String grp;
    @Id
    private String username;

    public User() {
        userRoles.add(new UserRole("default"));
    }

    @Override
    public String toString() {
        return "User{" +
                "userRoles=" + userRoles +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", group='" + grp + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }


    public String getEmail() {
        return email;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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


    public String getGroup() {
        return grp;
    }

    public void setGroup(String group) {
        this.grp = group;
    }
}
