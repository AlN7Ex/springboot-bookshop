package ru.mysak.springboot.crudbookshop.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Boolean createUser(@RequestBody UserView view) {
        User user = new User();
        user.setUsername(view.getLogin());
        user.setPassword(view.getPassword());
        user.setRoles(view.getRoles()
                .stream()
                .map(RoleView::getRole)
                .map(Role::new)
                .collect(Collectors.toSet()));
        userService.create(user);

        return true;
    }
}
