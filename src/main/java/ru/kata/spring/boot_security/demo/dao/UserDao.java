package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao {
    User getUserByEmail(String email);
    void addUser(User user);

    // исправлено замечание с задания 2.3.1 заменить примитивный тип на обёртку
    User getUserById(Long id);
    void updateUser(User user);

    // исправлено замечание с задания 2.3.1 заменить примитивный тип на обёртку
    void removeUserById(Long id);
    List<User> listUsers();
}