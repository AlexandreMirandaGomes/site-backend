package br.com.xande.sitebackend.repository;

import br.com.xande.sitebackend.entity.Authentication;
import br.com.xande.sitebackend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends CrudRepository<Authentication, Long> {

    Authentication findByToken(String token);

    List<Authentication> findAllByUser(User user);
}
