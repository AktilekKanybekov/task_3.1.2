package net.proselyte.springbootdemo_311.repository;

import net.proselyte.springbootdemo_311.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long> {
}
