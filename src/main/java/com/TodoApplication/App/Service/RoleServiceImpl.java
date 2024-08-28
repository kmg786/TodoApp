package com.TodoApplication.App.Service;

import com.TodoApplication.App.Exception.GlobalExceptionHandler.ResourceNotFoundException;
import com.TodoApplication.App.Model.Role;
import com.TodoApplication.App.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Role","RoleId",id));
        return role;
    }
}
