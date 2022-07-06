package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    Set<Role> getSetOfRoles(String[] roleNames);
    void add(Role role);
    void edit(Role role);

    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    Role getById(Long id);
}
