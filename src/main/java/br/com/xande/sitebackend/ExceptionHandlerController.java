package br.com.xande.sitebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;


@RestControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(value= HttpStatus.NOT_FOUND)// 404
    @ExceptionHandler(EntityNotFoundException.class)
    public Response notFound(EntityNotFoundException e) {
       return new Response(messageSource.getMessage("error.not.found",null, Locale.getDefault()));
    }

    @ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY)// 422
    @ExceptionHandler(BusinessException.class)
    public Response businessException(BusinessException e) {
        return new Response(e.getMessage());
    }






}
