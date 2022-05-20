package ru.mysak.springboot.crudbookshop.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
@Table(schema = "book_shop", name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    public Role(String role) {
        this.role = role;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "book_shop", name = "user_roles")
    private Set<User> users = new LinkedHashSet<>();

    @Transient
    @Override
    public String getAuthority() {
        return role;
    }
}
