package ru.mysak.springboot.crudbookshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/authors").hasRole("ADMIN")
//                .antMatchers("/books").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/swagger-ui/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

//    @Bean
//    public PasswordEncoder encoder() {
//
//        return new BCryptPasswordEncoder();
//    }
}
