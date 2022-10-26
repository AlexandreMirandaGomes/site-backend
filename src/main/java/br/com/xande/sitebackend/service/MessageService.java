package br.com.xande.sitebackend.service;

import br.com.xande.sitebackend.entity.Message;

import java.util.List;

public interface MessageService {

    void create(String message);

    Message get(Long id);

    void update(Long id, String message);

    void delete(Long id);

    List<Message> findAll(String text);

}
