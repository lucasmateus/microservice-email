package com.example.microserviceemail.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {

    @NotBlank
    @Email
    private String remetente;
    @NotBlank
    @Email
    private String destinatario;
    @NotBlank
    private String assunto;
    @NotBlank
    private String texto;
}
