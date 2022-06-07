package org.huseyin.springsecuritydemo.services;

import java.util.List;

import org.huseyin.springsecuritydemo.models.Role;
import org.huseyin.springsecuritydemo.models.User;

public interface UserService {

    User save(User user);
    Role save(Role role);
    void addRoleToUser(String username, String roleName);
    User get(String username);
    List<User> list();

}
