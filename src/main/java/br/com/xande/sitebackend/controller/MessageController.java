package br.com.xande.sitebackend.controller;

import br.com.xande.sitebackend.entity.Message;
import br.com.xande.sitebackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class MessageController {

    @Autowired
    MessageService service;

    @PostMapping("private/message")
    public void create(@RequestBody String message) {
        service.create(message);
    }

    @GetMapping("public/message/{id}")
    public Message get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("public/message")
    public List<Message> findAll(String text) {
        return service.findAll(text);
    }

    @PutMapping("private/message/{id}")
    public void update(@PathVariable Long id, @RequestBody String message) {
        service.update(id,message);
    }

    @DeleteMapping("private/message/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }



}
