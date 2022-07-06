package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    void addUser(User user);

    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    User getUserById(Long id);
    void updateUser(User user);

    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    void removeUserById(Long id);
    List<User> listUsers();
}