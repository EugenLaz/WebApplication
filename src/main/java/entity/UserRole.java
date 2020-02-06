package entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole  {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "role_name")
    String roleName;

    @ManyToOne
    @JoinColumn(name="username", nullable=false)
    private User user;

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
