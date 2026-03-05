package dev.stark.repository;


import dev.stark.entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}