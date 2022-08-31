package br.com.xande.sitebackend;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @SequenceGenerator(allocationSize = 1, schema = "public", sequenceName = "message_id_seq", name = "message_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    private Long id;
    @Column(length = 255)
    private String text;
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
