package br.com.xande.sitebackend.controller;

import br.com.xande.sitebackend.dto.AuthDTO;
import br.com.xande.sitebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("login")
    public String login (@RequestBody AuthDTO dto) {
        return authService.login(dto.getName(), dto.getPassword());
    }


}
