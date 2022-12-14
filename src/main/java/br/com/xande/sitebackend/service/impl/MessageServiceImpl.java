package br.com.xande.sitebackend.service.impl;

import br.com.xande.sitebackend.exception.BusinessException;
import br.com.xande.sitebackend.entity.Message;
import br.com.xande.sitebackend.repository.MessageRepository;
import br.com.xande.sitebackend.repository.UserRepository;
import br.com.xande.sitebackend.service.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class MessageServiceImpl extends GenericServiceImpl<Message> implements MessageService {

    private static final List<String> BADWORDS = new ArrayList<>(List.of("word1", "word2"));


    @Autowired
    private MessageRepository repository;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void create(String message) {

        if (BADWORDS.stream().anyMatch(badWord -> StringUtils.containsIgnoreCase(message, badWord))) {
            throw new BusinessException(messageSource.getMessage("error.bad.word", null, Locale.getDefault()));
        }


        Message message1 = new Message();
        message1.setText(message);
        message1.setDate(LocalDateTime.now());
        message1.setUser(userRepository.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
        repository.save(message1);
        System.out.println("Mensagem criada com sucesso: " + message);
    }

    @Override
    public void update(Long id, String text) {
        Optional<Message> optionalMessage = repository.findById(id);
        String loggedInEmail = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (optionalMessage.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "Mensagem não encontrada");
        }
        if(!loggedInEmail.equals(optionalMessage.get().getUser().getEmail())) {
            throw new AccessDeniedException("Não autorizado");
        }
        Message message = optionalMessage.get();
        message.setText(text);
        repository.save(message);
        System.out.println("Mensagem com o id " + id + " alterada para " + text);

    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresentOrElse(m -> {
            if (m.getUser().getEmail().equals(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())) {
                repository.deleteById(id);
            } else throw new AccessDeniedException("Não autorizado");
        }, () -> {
            throw new EntityNotFoundException("Entidade não encontrada");
        });

        System.out.println("Mensagem com o id " + id + " deletada com sucesso");
    }

    @Override
    public List<Message> findAll(String text) {
        if (StringUtils.isBlank(text)) {
            return repository.findAll();
        }
        return repository.findByTextContaining(text);


    }
}
