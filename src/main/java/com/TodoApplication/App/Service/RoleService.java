package com.TodoApplication.App.Service;

import com.TodoApplication.App.Model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role createRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);
}
