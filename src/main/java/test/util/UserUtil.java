package test.util;

import entity.User;
import entity.UserRole;

import java.math.BigInteger;

public class UserUtil {
    public static User createUser(){
        User user = new User();
        user.setUsername("underTest");
        user.setGroup("testers");
        user.setEmail("testingEmail");
        user.setPassword("111");
        user.addRole(new UserRole("admin"));
        user.setBalance(new BigInteger("100"));
        System.out.println(user);
        return user;
    }
}
