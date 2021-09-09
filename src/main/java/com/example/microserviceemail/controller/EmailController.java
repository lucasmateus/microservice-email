package com.example.microserviceemail.controller;

import com.example.microserviceemail.dto.EmailDTO;
import com.example.microserviceemail.model.Email;
import com.example.microserviceemail.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<Email> enviarEmail(@RequestBody @Valid EmailDTO emailDTO){
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);//converte de dto para model
        emailService.enviarEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
