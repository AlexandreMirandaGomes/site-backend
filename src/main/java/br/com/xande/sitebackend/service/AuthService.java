package br.com.xande.sitebackend.service;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface AuthService {

    String login(String name, String password) throws NoSuchAlgorithmException;

}
