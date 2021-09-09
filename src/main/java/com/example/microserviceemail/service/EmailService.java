package com.example.microserviceemail.service;

import com.example.microserviceemail.enums.StatusEmail;
import com.example.microserviceemail.model.Email;
import com.example.microserviceemail.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Email enviarEmail(Email email) {
        email.setDataDeEnvio(LocalDateTime.now());
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(email.getRemetente());
            simpleMailMessage.setTo(email.getDestinatario());
            simpleMailMessage.setSubject(email.getAssunto());
            simpleMailMessage.setText(email.getTexto());

            mailSender.send(simpleMailMessage);

            email.setStatusEmail(StatusEmail.ENVIADO);
        }catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(email);
        }
    }
}
