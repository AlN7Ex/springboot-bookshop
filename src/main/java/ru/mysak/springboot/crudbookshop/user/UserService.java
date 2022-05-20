package ru.mysak.springboot.crudbookshop.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void create(User user) {
        User exists = userRepository.findByUsername(user.getUsername());
        if (exists != null) {
            throw new EntityExistsException("user with username " + user.getUsername() + " already exist");
        }
        String password = passwordEncoder.encode(user.getPassword());

        user.setPassword(password);

        Set<String> roles = user.getRoles()
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());
        Set<Role> existRoles = roleRepository.findByRoleIn(roles);

        user.setRoles(existRoles);
        existRoles.forEach(role -> role.setUsers(Set.of(user)));

        userRepository.save(user);
    }

//    public void addRole(User user, Role role) {
//
//    }
}
