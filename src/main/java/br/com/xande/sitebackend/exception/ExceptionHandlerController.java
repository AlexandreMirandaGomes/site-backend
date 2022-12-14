package br.com.xande.sitebackend.exception;

import br.com.xande.sitebackend.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;


@RestControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)// 404
    @ExceptionHandler(EntityNotFoundException.class)
    public Response notFound(EntityNotFoundException e) {
        return new Response(messageSource.getMessage("error.not.found", null, Locale.getDefault()));
    }


    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)// 422
    @ExceptionHandler(BusinessException.class)
    public Response businessException(BusinessException e) {
        return new Response(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)// 401
    @ExceptionHandler(AuthenticationException.class)
    public Response badCredentialsException(AuthenticationException e) {
        return new Response(messageSource.getMessage("error.not.found", null, Locale.getDefault()));
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)// 403
    @ExceptionHandler(AccessDeniedException.class)
    public Response accessDeniedException(AccessDeniedException e) {
        return new Response(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)// 400
    @ExceptionHandler(UserSignedUpException.class)
    public Response userSignedUpException(UserSignedUpException e) {
        return new Response(e.getMessage());
    }


}
