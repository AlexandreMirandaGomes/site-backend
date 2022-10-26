package br.com.xande.sitebackend.service;

import br.com.xande.sitebackend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void create(String name, String password);

    User get(Long id);

    void put(Long id,String name, String password);

    void delete(Long id);

}
