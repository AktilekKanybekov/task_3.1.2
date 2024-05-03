package net.proselyte.springbootdemo_311.service;

import net.proselyte.springbootdemo_311.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
