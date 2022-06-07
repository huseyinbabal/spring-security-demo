package org.huseyin.springsecuritydemo.controllers;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.huseyin.springsecuritydemo.models.User;
import org.huseyin.springsecuritydemo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping("/roles")
    public void addRoles(@RequestBody AddRolesRequest request) {
        userService.addRoleToUser(request.getUsername(), request.getRole());
    }

    @Data
    class AddRolesRequest {
        private String username;
        private String role;
    }
}
