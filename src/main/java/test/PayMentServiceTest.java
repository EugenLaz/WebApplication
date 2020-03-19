package test;

import Services.Other.PaymentService;
import entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import test.config.TestDataBaseConfig;

import java.math.BigInteger;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class PayMentServiceTest {
    @Autowired
    private PaymentService paymentService;


    private User fromUser;
    private User toUser;

    @Before
    public void initUsers() {
        fromUser = new User();
        fromUser.setUsername("fromUser");
        fromUser.setPassword("12");
        fromUser.setBalance(BigInteger.valueOf(100));
        toUser = new User();
        toUser.setPassword("44");
        toUser.setUsername("toUser");
        toUser.setBalance(BigInteger.valueOf(130));
    }

    @Test
    public void shouldFailIfNotEnoughBalance() {
        Assert.assertFalse(paymentService.processPayment(fromUser, toUser, BigInteger.valueOf(220)));
    }

    @Test
    public void shouldMakeStandartPayment() {
        Assert.assertTrue(paymentService.processPayment(fromUser, toUser, BigInteger.valueOf(50)));
        Assert.assertEquals(BigInteger.valueOf(50), fromUser.getBalance());
        Assert.assertEquals(BigInteger.valueOf(180), toUser.getBalance());
    }

    @Test
    public void shouldFailOnZeroPayment() {
        Assert.assertFalse(
                paymentService.processPayment(fromUser, toUser, BigInteger.valueOf(0))
        );
    }

    @Test
    public void shouldFailOnNegativeValuePayment() {
        Assert.assertFalse(
                paymentService.processPayment(fromUser, toUser, BigInteger.valueOf(-1))
        );
    }

}
