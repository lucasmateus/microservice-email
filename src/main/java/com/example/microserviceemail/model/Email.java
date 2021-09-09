package com.example.microserviceemail.model;

import com.example.microserviceemail.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email")
public class Email {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String remetente;
    private String destinatario;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String texto;
    private LocalDateTime dataDeEnvio;
    private StatusEmail statusEmail;
}
