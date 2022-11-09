package br.com.xande.sitebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AuthenticationFailException extends RuntimeException{
    public AuthenticationFailException(String msg) {
        super(msg);
    }
}
