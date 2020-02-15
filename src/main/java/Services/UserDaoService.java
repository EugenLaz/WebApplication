package Services;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDaoService {
    Optional<User> getByUserName(String username);
    List<User> getAll();
    void saveUser(User user);
    void deleteUser(String  username);
}
