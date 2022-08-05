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
// так же убрал конструктор создания new и заавтоваирил.


    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDao = userDao;
    }
    //Transactional(readOnly = true)
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {

        return userDao.getUserByEmail(email);
    }
    //Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeUserById(Long id) {

        userDao.removeUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {

        return userDao.listUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }
}