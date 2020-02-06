package Services;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getByUserName(String username);
    List<User> getAll();
    void saveUser(User user);
}
