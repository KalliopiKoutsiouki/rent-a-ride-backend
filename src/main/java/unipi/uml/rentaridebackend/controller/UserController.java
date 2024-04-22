package unipi.uml.rentaridebackend.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unipi.uml.rentaridebackend.model.User;
import unipi.uml.rentaridebackend.model.UserRole;
import unipi.uml.rentaridebackend.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/all"})
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/new")
    public User addNewUser(@RequestBody User userInfo) {
        setRoleIfUndefined(userInfo);
        return userService.addUser(userInfo);
    }

    private void setRoleIfUndefined(User userinfo) {
        Set<UserRole> roles = new HashSet<>();
        if (userinfo.getUserRoles() == null) {
            roles.add(UserRole.ROLE_USER);
            userinfo.setUserRoles(roles);
        }
    }

}
