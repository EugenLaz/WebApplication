package entity;



import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userRoles, user.userRoles) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(grp, user.grp) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
                CascadeType.MERGE,
    },fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRole> userRoles = new ArrayList<>();
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

    public void addRole(UserRole userRole) {
        this.userRoles.add(userRole);
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
