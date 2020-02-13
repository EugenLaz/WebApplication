package Controller;


import Config.Security.SecurityHandler;
import Services.impl.UserServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceImpl dao;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/register")
    public ModelAndView processData(@RequestParam(name = "j_username") String name, @RequestParam("j_password") Object repetedPassword,
                                    @RequestParam(name = "j_password_repeated") Object password) {
        if(!password.equals(repetedPassword)){
            return null;
        }
        User user = new User();
        user.setUsername(name);
        user.setPassword(password.toString());
        dao.saveUser(user);
        try {
            request.login(name,password.toString());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("resources/view/ProfileChange");
        return modelAndView;
    }


}
