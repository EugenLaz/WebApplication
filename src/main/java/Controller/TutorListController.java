package Controller;

import Services.UserDaoService;
import Services.impl.UserDaoServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TutorListController {

    @Autowired
    UserDaoServiceImpl dao;
    @RequestMapping("/tutorList")
    public ModelAndView loadTutors(){
        List<User> tutors =dao.getAllTutors();
        System.out.println(tutors);
        ModelAndView mav = new ModelAndView("view/Student/TutorsList");
        mav.addObject("tutors",tutors);

        return mav;
    }



}

