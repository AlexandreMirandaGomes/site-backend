package br.com.xande.sitebackend.controller;

import br.com.xande.sitebackend.dto.UserDTO;
import br.com.xande.sitebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signup")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void signUp(@RequestBody UserDTO dto) {
        userService.signUp(dto.getEmail(), dto.getPassword());
    }


}
