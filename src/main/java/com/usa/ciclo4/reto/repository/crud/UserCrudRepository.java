package com.usa.ciclo4.reto.repository.crud;

import com.usa.ciclo4.reto.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    public List<User> findByNameOrEmail(String name, String email);
}
