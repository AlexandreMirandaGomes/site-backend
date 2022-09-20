package br.com.xande.sitebackend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTextContaining(String text);

    @Query("SELECT m FROM Message m WHERE m.text like %:text%")
    List<Message> findByTextContainingJPQL(String text);

    @Query(value = "select * from message m where text ilike %:text%", nativeQuery = true)
    List<Message> findByTextContainingNativeQuery(String text);

}
