package Services.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendSimpleMessage(
            String reciveAdress, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("<EYLA_noreplay@gmail.com>");
        message.setTo(reciveAdress);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
