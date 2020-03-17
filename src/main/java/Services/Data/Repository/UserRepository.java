package Services.Data.Repository;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "SELECT * FROM users,user_role,roles Where user_role.username = users.username AND user_role.role_id = roles.id AND roles.role_name=\"tutor\"",nativeQuery = true)
     List<User> getAllTutors();
    
}
