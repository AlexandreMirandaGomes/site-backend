package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.entity.Authentication;
import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.exception.AuthenticationFailException;
import br.com.xande.sitebackend.repository.TokenRepository;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public String signIn(String name, String password) throws NoSuchAlgorithmException {

        User user = userRepository.findByEmail(name);

        if(Objects.isNull(user)) {
            throw new AuthenticationFailException("usuário não encontrado");
        }

        String encryptedPassword = hashPassword(password);

        if(!encryptedPassword.equals(user.getPassword())) {
            throw new AuthenticationFailException("Login/password podem estar incorretos");
        }

        return generateToken(user);

    }

    @Override
    public String generateToken(User user) {

        Authentication authentication = new Authentication(user);

        tokenRepository.save(authentication);

        return authentication.getToken();

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
