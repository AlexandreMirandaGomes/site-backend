package br.com.xande.sitebackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cad_user")
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(allocationSize = 1, schema = "public", sequenceName = "user_id_seq", name = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;
    private String email;
    private String password;
    private LocalDate created;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.created = LocalDate.now();
    }


}
