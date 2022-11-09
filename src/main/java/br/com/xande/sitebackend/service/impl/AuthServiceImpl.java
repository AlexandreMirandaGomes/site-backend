package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.exception.AuthenticationFailException;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String name, String password) throws NoSuchAlgorithmException {

        User user = userRepository.findByEmail(name);

        if(Objects.isNull(user)) {
            throw new AuthenticationFailException("usuário não encontrado");
        }

        if (!name.equals(user.getEmail())) {
            throw new AuthenticationFailException("login errado");
        }

        String encryptedPassword = hashPassword(password);

        if(!encryptedPassword.equals(user.getPassword())) {
            throw new AuthenticationFailException("Password errado");
        }

        userRepository.save(user);

        return "success";

    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }


}
