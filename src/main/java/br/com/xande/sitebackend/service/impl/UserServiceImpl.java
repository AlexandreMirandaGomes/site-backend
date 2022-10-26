package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void create(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setCreated(LocalDate.now());
        userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void put(Long id, String name, String password) {

    }

    @Override
    public void delete(Long id) {

    }
}
