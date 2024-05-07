package net.proselyte.springbootdemo_311.service;

import net.proselyte.springbootdemo_311.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    void createUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getUsersAndRoles();
}
