package org.huseyin.springsecuritydemo.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;

public class CustomHttpConfigurer extends AbstractHttpConfigurer<CustomHttpConfigurer, HttpSecurity> {

    @Override
    public void init(HttpSecurity builder) throws Exception {
       builder
            .cors().and().csrf().disable()
           .authorizeRequests((auth) -> {
               auth.antMatchers(GET, "/api/users/**").hasAnyAuthority("ROLE_USER");
               auth.antMatchers(POST, "/api/users/**").hasAnyAuthority("ROLE_ADMIN");
               auth.antMatchers(PATCH, "/api/users/**").hasAnyAuthority("ROLE_ADMIN");
               auth.antMatchers(POST, "/api/roles/**").hasAnyAuthority("ROLE_ADMIN");
               auth.anyRequest().permitAll();
           }).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(HttpSecurity http) {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http
            .addFilter(new JwtAuthorizationFilter(authenticationManager))
            .addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    public static CustomHttpConfigurer customDsl() {
        return new CustomHttpConfigurer();
    }
}
