package net.proselyte.springbootdemo_311.repository;

import net.proselyte.springbootdemo_311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);


    @Query("SELECT u FROM User u JOIN FETCH u.roles r")
    List<User> listUsersAndRoles();
}
