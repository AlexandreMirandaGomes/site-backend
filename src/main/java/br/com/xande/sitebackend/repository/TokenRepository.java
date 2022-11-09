package br.com.xande.sitebackend.repository;

import br.com.xande.sitebackend.entity.Authentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Authentication, Long> {


}
