package test.util;

import entity.User;
import entity.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    public static User createUser(){
        User user = new User();
        user.setUsername("underTest");
        user.setGroup("testers");
        user.setEmail("testingEmail");
        user.setPassword("111");
        return user;
    }
}
