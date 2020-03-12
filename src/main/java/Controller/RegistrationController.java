package Controller;


import Services.PasswordEncodingService;
import Services.UserDaoService;
import Services.impl.UserDaoServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RegistrationController {

    @Autowired
    private UserDaoServiceImpl dao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PasswordEncodingService encoder;

    @RequestMapping(value = "/register")
    public ModelAndView processData(@RequestParam(name = "j_username") String name, @RequestParam("j_password") Object repetedPassword,
                                    @RequestParam(name = "j_password_repeated") Object password, HttpServletResponse response) {
        if(!password.equals(repetedPassword) || validate(name) ){
            return null;
        }
        User user = new User();
//        System.out.println(BCryptPasswordEncoder.BCryptVersion.valueOf(password.toString()));
        user.setUsername(name);
        user.setPassword(encoder.encode(password.toString()));
        dao.saveUser(user);
        try {
            request.login(name,password.toString());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("/view/Student/studentHome");
        return mav;
    }

    private boolean validate(String name){
        return dao.getByUserName(name).isPresent();
    }


}
