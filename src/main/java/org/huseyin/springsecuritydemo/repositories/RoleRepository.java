package org.huseyin.springsecuritydemo.repositories;

import org.huseyin.springsecuritydemo.models.Role;
import org.huseyin.springsecuritydemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
