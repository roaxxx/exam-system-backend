package com.exam.system.exam.controllers;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exam.system.exam.model.Rol;
import com.exam.system.exam.model.User;
import com.exam.system.exam.model.UserRol;
import com.exam.system.exam.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) throws Exception {
        Set<UserRol> userRols = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolName("NORMAL");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        return userService.saveUser(user, userRols);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("usernanme") String username) {
        userService.deleteUserByUsername(username);
    }
}
