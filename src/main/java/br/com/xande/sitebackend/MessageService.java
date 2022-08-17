package br.com.xande.sitebackend;

public interface MessageService {

    void create(String message);

    String get(Long id);

    void update(Long id, String message);

    void delete(Long id);
}
