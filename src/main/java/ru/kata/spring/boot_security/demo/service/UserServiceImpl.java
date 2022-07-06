package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
//заинжетил модификатор доступа BCryptPasswordEncoder
    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }
    //Transactional(readOnly = true)
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {

        return userDao.getUserByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }
    //изменён на обёртку в связи с последнем замечанием в 2.3.1
    //Transactional(readOnly = true)
    @Transactional(readOnly = true)
    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    @Override
    public void removeUserById(Long id) {

        userDao.removeUserById(id);
    }

    @Override
    public List<User> listUsers() {

        return userDao.listUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }
}