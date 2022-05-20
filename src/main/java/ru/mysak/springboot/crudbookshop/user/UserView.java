package ru.mysak.springboot.crudbookshop.user;

import lombok.Data;

import java.util.Set;

@Data
public class UserView {

    private String login;
    private String password;
    private Set<RoleView> roles;
}
