package com.usa.ciclo4.reto.service;

import com.usa.ciclo4.reto.model.User;
import com.usa.ciclo4.reto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getName() == null) {
            return user;
        } else {
            List<User> exist = userRepository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            if (exist.isEmpty()) {
                if (user.getId() == null) {
                    return userRepository.save(user);
                } else if (userRepository.getUser(user.getId()).isEmpty()) {
                    userRepository.save(user);
                }
            }
        }return user;
    }

    public boolean emailExists(String email) {
        if (userRepository.emailExists(email).isEmpty()) {
            return false;
        }
        return true;
    }

    public Optional<User> userExists(String email, String password) {
        Optional<User> user = userRepository.userExists(email, password);
        if (user.isEmpty()) {
            return Optional.of(new User(null, email, password, "NO DEFINIDO"));
        }
        return user;
    }
}