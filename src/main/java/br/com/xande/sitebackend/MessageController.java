package br.com.xande.sitebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageService service;

    @PostMapping
    public void create(@RequestBody String message) {
        service.create(message);
    }

    @GetMapping("{id}")
    public Message get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody String message) {
        service.update(id,message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
