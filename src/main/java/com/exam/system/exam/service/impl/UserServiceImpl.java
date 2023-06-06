package com.exam.system.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.system.exam.model.User;
import com.exam.system.exam.model.UserRol;
import com.exam.system.exam.repository.RolRepository;
import com.exam.system.exam.repository.UserRepository;
import com.exam.system.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public User saveUser(User user, Set<UserRol> userRols) throws Exception {

        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            System.out.print("El usuario ya ha sigo ingresado");
            throw new Exception("El usuario ya existe");
        } else {
            for (UserRol userRol : userRols) {
                rolRepository.save(userRol.getRol());
            }
            user.getUserRols().addAll(userRols);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User getUser(String usernanme) {
        return userRepository.findByUsername(usernanme);
    }

    @Override
    public void deleteUserById(Long idUser) {
        userRepository.deleteById(idUser);
    }

}
