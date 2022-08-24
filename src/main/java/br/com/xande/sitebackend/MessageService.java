package br.com.xande.sitebackend;

import java.util.Optional;

public interface MessageService {

    void create(String message);

    Message get(Long id);

    void update(Long id, String message);

    void delete(Long id);
}
