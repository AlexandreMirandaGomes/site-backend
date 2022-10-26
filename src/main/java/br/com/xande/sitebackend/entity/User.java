package br.com.xande.sitebackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_credentials")
public class User {
    @Id
    @SequenceGenerator(allocationSize = 1, schema = "public", sequenceName = "user_id_seq", name = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;
    private String name;
    private String password;
    private LocalDate created;
}
