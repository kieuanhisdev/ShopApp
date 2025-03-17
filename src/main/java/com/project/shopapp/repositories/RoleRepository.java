package com.project.shopapp.repositories;

import com.project.shopapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRolesById(Long id);

    Role getRolesByRoleName(String roleName);
//    Optional<Role> findByName(String name);
}
