package test.util;

import entity.User;
import entity.UserRole;

public class UserUtil {
    public static User createUser(){
        User user = new User();
        user.setUsername("underTest");
        user.setGroup("testers");
        user.setEmail("testingEmail");
        user.setPassword("111");
        user.addRole(new UserRole("admin"));
        System.out.println(user);
        return user;
    }
}
