package test;

import Services.PaymentService;
import Services.UserDaoService;
import entity.User;
import entity.UserRole;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import test.config.TestDataBaseConfig;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigInteger;
import java.util.Optional;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserDaoServiceTest {

    @Autowired
    private UserDaoService userDaoService;

    User user;
    @Before
    public void initUser(){
        user = new User();
        user.setUsername("underTest");
        user.setGroup("testers");
        user.setEmail("testingEmail");
        user.setPassword("111");
        user.addRole(new UserRole("admin"));
        user.setBalance(new BigInteger("100"));
    }

    @Test
    public void shouldSaveUserByUsername() throws Exception {
        userDaoService.saveUser(user);
    }

    @Test
    public void shouldLoadUserByExistingName() throws Exception{
        userDaoService.saveUser(user);
        User fromDbUser = userDaoService.getByUserName("underTest").get();
        Assert.assertEquals(user,fromDbUser);
    }

    @Test
    public void shouldReturnEmptyOnNonExisitingUser(){
        Assert.assertEquals(Optional.empty(),
                userDaoService.getByUserName("nonExisting"));
    }
    @Test
    public void shouldUpdatedUsersName(){
        userDaoService.saveUser(user);
        user.setName("newName");
        userDaoService.saveUser(user);
        Assert.assertEquals("newName",
                userDaoService.getByUserName(user.getUsername()).get().getName());
    }


    @Test
    public void shouldDeleteUserByUsername(){
        userDaoService.saveUser(user);
        Assert.assertTrue(
        userDaoService.deleteUser(user.getUsername())
        );
        Assert.assertEquals(Optional.empty(),userDaoService.getByUserName(user.getUsername()));
    }
    @Test
    public void shouldReturnFalseOnNonExistingUserDelete(){
        Assert.assertFalse(
        userDaoService.deleteUser("nonExist"));
    }




}
