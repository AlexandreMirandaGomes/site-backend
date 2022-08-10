package br.com.xande.sitebackend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class MessageController {

    @PostMapping
    public void create(@RequestBody String message) {
        System.out.println("Mensagem criada:" + message);
    }

    @GetMapping("{id}")
    public String get(@PathVariable Long id) {
        return "Mensagem com id " + id + " obtida";
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id) {
        System.out.println("A mensagem de id " + id + " foi atualizada");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("A mensagem de id " + id + " foi deletada");
    }

}
