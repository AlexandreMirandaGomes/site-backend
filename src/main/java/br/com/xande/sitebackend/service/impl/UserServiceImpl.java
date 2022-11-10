package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.entity.Authentication;
import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.exception.AuthenticationFailException;
import br.com.xande.sitebackend.repository.TokenRepository;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthServiceImpl authService;

    @Override
    @Transactional
    public String signUp(String email, String password) {

        if(Objects.nonNull(userRepository.findByEmail(email))) {
            throw new AuthenticationFailException("Usuário já cadastrado");
        }

        String encryptedPassword = null;
        try {
            encryptedPassword = authService.hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        User user = new User(email,encryptedPassword);
        userRepository.save(user);

        return authService.generateToken(user);


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
