package unipi.uml.rentaridebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.User;
import unipi.uml.rentaridebackend.repository.UserRepository;
import unipi.uml.rentaridebackend.service.UserService;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public UserServiceImpl(final UserRepository repository, final PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return repository.save(userInfo);
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
