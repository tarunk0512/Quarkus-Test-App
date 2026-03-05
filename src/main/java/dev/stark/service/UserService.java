package dev.stark.service;

import dev.stark.dto.UserRequest;
import dev.stark.dto.UserResponse;
import dev.stark.entity.User;
import dev.stark.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserResponse> getAllUsers() {

        return userRepository.listAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUser(Long id) {

        User user = userRepository.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return mapToResponse(user);
    }

    @Transactional
    public UserResponse createUser(UserRequest request) {

        User user = new User();
        user.name = request.name;
        user.email = request.email;
        user.age = request.age;

        userRepository.persist(user);

        return mapToResponse(user);
    }

    @Transactional
    public UserResponse updateUser(Long id, UserRequest request) {

        User user = userRepository.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.name = request.name;
        user.email = request.email;
        user.age = request.age;

        return mapToResponse(user);
    }

    @Transactional
    public void deleteUser(Long id) {

        boolean deleted = userRepository.deleteById(id);

        if (!deleted) {
            throw new RuntimeException("User not found");
        }
    }

    private UserResponse mapToResponse(User user) {

        return new UserResponse(
                user.id,
                user.name,
                user.email,
                user.age
        );
    }
}