package br.com.xande.sitebackend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY, reason = "Regra de negócio violada")
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
