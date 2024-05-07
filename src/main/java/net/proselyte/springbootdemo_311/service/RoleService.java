package net.proselyte.springbootdemo_311.service;

import net.proselyte.springbootdemo_311.model.Role;

import java.util.List;


public interface RoleService {
    void createRole(Role role);

    Role findRoleById(Long Id);

    Role updateRole(Role role);

    void deleteRoleById(Long Id);

    List<Role> findAllRoles();
}