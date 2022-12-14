package br.com.xande.sitebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class GenericServiceImpl<T> {

    @Autowired
    private CrudRepository<T, Long> repository;

    public T get(Long id) {
        Optional<T> t = repository.findById(id);
        if (t.isPresent()) {
            System.out.println("Entidade com o id " + id + " obtida com sucesso");
            return t.get();
        }
        throw new EntityNotFoundException();
    }

}
