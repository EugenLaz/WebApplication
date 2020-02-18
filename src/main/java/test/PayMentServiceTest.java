package test;

import Services.PaymentService;
import Services.UserDaoService;
import entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import test.config.TestDataBaseConfig;
import test.util.UserUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigInteger;
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class PayMentServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private UserDaoService userDaoService;

    @Test
    public void transferFailTest(){
        User fromUser = UserUtil.createUser();
        User toUser = new User();
        toUser.setPassword("44");
        toUser.setUsername("toUser");
        toUser.setBalance(BigInteger.valueOf(130));
        Assert.assertFalse(paymentService.processPayment(fromUser,toUser,BigInteger.valueOf(220)));
    }
    @Test
    public void transferTest(){
        User fromUser = UserUtil.createUser();
        User toUser = new User();
        toUser.setPassword("44");
        toUser.setUsername("toUser");
        toUser.setBalance(BigInteger.valueOf(0));
        Assert.assertTrue(paymentService.processPayment(fromUser,toUser,BigInteger.valueOf(50)));
    }
}
