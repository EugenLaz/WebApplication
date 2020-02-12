package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name")
    String roleName;

    @ManyToMany(mappedBy = "userRoles")
    private List<User> posts = new ArrayList<>();

    @Override
    public String toString() {
        return  roleName;
    }

    public UserRole(String role) {
        roleName = role;
    }
    public UserRole() {
    }

}
