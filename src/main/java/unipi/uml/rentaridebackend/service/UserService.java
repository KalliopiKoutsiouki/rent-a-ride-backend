package unipi.uml.rentaridebackend.service;

import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getAllUsers();

    User addUser(User userInfo);

    Optional<User> getUserById(Long userId) ;

    User updateUser(Long userId, User updatedUser);

    boolean deleteUser(Long userId);

    Optional<User> getUserByUserName(String userName);
}
