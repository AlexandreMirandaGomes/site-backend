package br.com.xande.sitebackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Message {
    @Id
    @SequenceGenerator(allocationSize = 1, schema = "public", sequenceName = "message_id_seq", name = "message_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    private Long id;
    @Column(length = 255)
    private String text;
    private LocalDateTime date;
}



