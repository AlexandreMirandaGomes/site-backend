package br.com.xande.sitebackend.controller;

import br.com.xande.sitebackend.dto.AuthDTO;
import br.com.xande.sitebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("public/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("signin")
    public String signIn (@RequestBody AuthDTO dto) throws NoSuchAlgorithmException {
        return authService.signIn(dto.getName(), dto.getPassword());
    }


}
