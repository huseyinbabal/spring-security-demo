package org.huseyin.springsecuritydemo.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.huseyin.springsecuritydemo.models.Role;
import org.huseyin.springsecuritydemo.models.User;
import org.huseyin.springsecuritydemo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final UserService userService;

    @PostMapping
    public Role save(@RequestBody Role role) {
        return userService.save(role);
    }
}
