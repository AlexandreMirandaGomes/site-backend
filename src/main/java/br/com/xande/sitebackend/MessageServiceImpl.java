package br.com.xande.sitebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public void create(String message) {
        if (message.length() > 255) {
            throw new RuntimeException("Mensagem muito grande");
        }
        Message message1 = new Message();
        message1.setText(message);
        message1.setDate(new Date());
        repository.save(message1);
        System.out.println(repository.count());
        System.out.println("Mensagem criada com sucesso: " + message);
    }

    @Override
    public String get(Long id) {
        System.out.println("Mensagem com o id " + id + " obtida com sucesso");
        return "Gostei do seu projeto";
    }

    @Override
    public void update(Long id, String message) {
        System.out.println("Mensagem com o id " + id + " alterada para " + message);
    }

    @Override
    public void delete(Long id) {
        System.out.println("Mensagem com o id " + id + " deletada com sucesso");
    }
}
