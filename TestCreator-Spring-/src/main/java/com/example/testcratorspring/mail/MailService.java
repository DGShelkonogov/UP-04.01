package com.example.testcratorspring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.ScannerImpl;

@Service
public class MailService{

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    JavaMailSender mailSender;

    public void send(String emailTo, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject("Confirm code");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
