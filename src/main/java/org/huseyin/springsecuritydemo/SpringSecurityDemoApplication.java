package org.huseyin.springsecuritydemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.huseyin.springsecuritydemo.models.Role;
import org.huseyin.springsecuritydemo.models.User;
import org.huseyin.springsecuritydemo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }


    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
          userService.save(Role.builder().name("ROLE_USER").build());
          userService.save(Role.builder().name("ROLE_ADMIN").build());

          userService.save(User.builder().name("John").username("jdoe").password("12234").roles(new HashSet<>()).build());

          userService.addRoleToUser("jdoe", "ROLE_USER");
        };
    }
}
