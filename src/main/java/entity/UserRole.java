package entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class UserRole  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return roleName.equals(userRole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }

    @Column(name = "role_name",unique = true)
    String roleName;

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> roles = new HashSet<>();

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
