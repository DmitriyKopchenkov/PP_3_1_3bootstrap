package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


//так же часть кода взята с //Часть кода взята с https://www.codejava.net/frameworks/spring-boot/spring-security-add-roles-to-user-examples от
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // до сюда + изменён на обёртку в связи с последнем замечанием в 2.3.1

    @Column(name = "name", unique = true, length = 100)
    private String role;

    public Role() {

    }
    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    public Role(Long id) {

        this.id = id;
    }

    public Role(String role) {

        this.role = role;
    }

    public Long getId() {

        return id;
    }
    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    public void setId(Long id) {

        this.id = id;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }

    @Override
    public String getAuthority() {

        return getRole();
    }

    @Override
    public String toString() {

        return role;

    }
}
