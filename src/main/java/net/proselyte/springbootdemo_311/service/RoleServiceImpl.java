package net.proselyte.springbootdemo_311.service;

import net.proselyte.springbootdemo_311.model.Role;
import net.proselyte.springbootdemo_311.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role findRoleById(Long Id) {
        return roleRepository.getById(Id);
    }

    @Transactional
    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    @Override
    public void deleteRoleById(Long Id) {
        roleRepository.deleteById(Id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
