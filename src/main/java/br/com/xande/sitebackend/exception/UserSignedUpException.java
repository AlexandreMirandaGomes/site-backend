package br.com.xande.sitebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserSignedUpException extends IllegalArgumentException {
    public UserSignedUpException(String msg) {
        super(msg);
    }
}
