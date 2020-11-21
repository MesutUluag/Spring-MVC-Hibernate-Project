package com.mesut.springdemo.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("Mesut").password("123456").roles("ADMIN"))
                .withUser(users.username("Sinem").password("123456").roles("USER"))
                .withUser(users.username("Ali").password("123456").roles("USER"));
    }
}
