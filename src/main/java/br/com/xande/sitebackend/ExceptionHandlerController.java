package br.com.xande.sitebackend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="Entidade não encontrada")  // 404
    @ExceptionHandler(EntityNotFoundException.class)
    public Message notFound(EntityNotFoundException e) {
        return new Message();
    }


}
