package br.com.xande.sitebackend.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @SequenceGenerator(allocationSize = 1, schema = "public", sequenceName = "authentication_id_seq", name = "authentication_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authentication_id_seq")
    private Long id;

    private String token;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public Authentication(User user) {
        this.user = user;
        this.createdDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }
}
