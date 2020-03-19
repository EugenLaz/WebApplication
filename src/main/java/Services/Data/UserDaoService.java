package Services.Data;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDaoService {
    Optional<User> getByUserName(String username);

    List<User> getAll();

    boolean saveUser(User user);

    boolean deleteUser(String username);

    List<User> getAllTutors();
}
