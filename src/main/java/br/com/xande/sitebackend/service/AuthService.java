package br.com.xande.sitebackend.service;

import br.com.xande.sitebackend.entity.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface AuthService {

    String signIn(String name, String password) throws NoSuchAlgorithmException;

    String generateToken(User user);
}
