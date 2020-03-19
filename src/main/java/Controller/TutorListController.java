package Controller;

import Services.Data.impl.UserDaoServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TutorListController {

    @Autowired
    UserDaoServiceImpl dao;

    @RequestMapping("/tutorList")
    public ModelAndView loadTutors() {
        List<User> tutors = dao.getAllTutors();
        ModelAndView mav = new ModelAndView("/view/protected/Student/TutorsList");
        mav.addObject("tutors", tutors);
        System.out.println(tutors.toString());
        return mav;
    }

    @RequestMapping("/openTutor/*")
    public ModelAndView tutorPage(HttpServletRequest request) {
        String username = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1);
        ModelAndView mav = new ModelAndView("/view/protected/Student/ReviewTutorPage");
        mav.addObject("tutor", dao.getByUserName(username).get());
        return mav;
    }

}

