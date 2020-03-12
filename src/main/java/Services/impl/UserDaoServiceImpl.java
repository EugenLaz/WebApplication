package Services.impl;

import DAO.Repository.UserRepository;
import Services.UserDaoService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getByUserName(String username) {
        return userRepository.findById(username);
    }

    @Override
    public List<User> getAll() {
        List<User> user = userRepository.findAll();
        return user;
    }

    public boolean saveUser(User user) {
        System.out.println(user.toString());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            userRepository.deleteById(username);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }


}
