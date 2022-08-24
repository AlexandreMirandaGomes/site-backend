package br.com.xande.sitebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public void create(String message) {
        Message message1 = new Message();
        message1.setText(message);
        message1.setDate(LocalDate.now());
        repository.save(message1);
        System.out.println(repository.count());
        System.out.println("Mensagem criada com sucesso: " + message);
    }

    @Override
    public Message get(Long id) {
        Optional<Message> message = repository.findById(id);
        if(message.isPresent()) {
            System.out.println("Mensagem com o id " + id + " obtida com sucesso");
            return message.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Mensagem não encontrada");
    }

    @Override
    public void update(Long id, String text) {
        Optional<Message> optionalMessage = repository.findById(id);
        if(optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setText(text);
            repository.save(message);
            System.out.println("Mensagem com o id " + id + " alterada para " + text);
        }
        throw new ResponseStatusException(NOT_FOUND, "Mensagem não encontrada");
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        System.out.println("Mensagem com o id " + id + " deletada com sucesso");
    }
}
