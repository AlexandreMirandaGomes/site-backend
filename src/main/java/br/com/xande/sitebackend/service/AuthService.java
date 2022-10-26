package br.com.xande.sitebackend.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    String login(String name, String password);

}
