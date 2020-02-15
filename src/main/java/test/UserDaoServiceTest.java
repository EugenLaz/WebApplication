package test;

import Services.UserDaoService;
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
import test.util.UserUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserDaoServiceTest {

    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private UserDaoService userDaoService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }
    @Test
    public void testSaveUser() throws Exception {
        UserUtil.createUser();
        userDaoService.saveUser(UserUtil.createUser());
    }

    @Test
    public void testLoadUser() throws Exception{
        User fromDbUser = userDaoService.getByUserName("underTest").get();
        Assert.assertEquals(fromDbUser,UserUtil.createUser());
    }
    @Test
    public void deleteUser(){
        userDaoService.deleteUser(UserUtil.createUser().getUsername());
    }


}
