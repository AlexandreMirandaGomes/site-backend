package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.exception.BusinessException;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String name, String password) {

        User user = userRepository.findByName(name);

        if (!name.equals(user.getName())) {
            throw new BusinessException("Nome errado");
        }

        if(!password.equals(user.getPassword())) {
            throw new BusinessException("Password errado");
        }

        return "success";


    }


}
