package com.exam.system.exam.service;

import java.util.Set;

import com.exam.system.exam.model.User;
import com.exam.system.exam.model.UserRol;

public interface UserService {

    public User saveUser(User user, Set<UserRol> userRols) throws Exception;

    public User getUser(String usernanme);

    public void deleteUserByUsername(String idUser);
}
