package net.proselyte.springbootdemo_311.service;

import net.proselyte.springbootdemo_311.model.User;
import net.proselyte.springbootdemo_311.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User readUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsersAndRoles() {
        return userRepository.listUsersAndRoles();
    }
}
