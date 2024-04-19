package unipi.uml.rentaridebackend.service.impl;

import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.User;
import unipi.uml.rentaridebackend.service.UserService;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User addUser(User userInfo) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return Optional.empty();
    }
}
