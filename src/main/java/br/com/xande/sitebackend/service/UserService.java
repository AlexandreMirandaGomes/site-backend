package br.com.xande.sitebackend.service;

import br.com.xande.sitebackend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String signUp(String email, String password);

    User get(Long id);

    void put(Long id,String name, String password);

    void delete(Long id);

}
