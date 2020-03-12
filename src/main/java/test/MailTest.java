package test;


import Config.MailConfig;
import Services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import test.config.TestDataBaseConfig;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataBaseConfig.class, MailConfig.class})
@WebAppConfiguration
public class MailTest {

    @Autowired
    MailService sender;

    static String message="message";
    static String subject ="topic";
    @Test
    public void shouldSendEmailOnExistingAdress(){
        sender.sendSimpleMessage("<lazhynce@gmail.com>",subject,message);
    }

    @Test(expected =org.springframework.mail.MailSendException.class)
    public void shouldSendErrorOnInvalidEmail(){
        sender.sendSimpleMessage("<lazhynce>",subject,message);
    }


}
