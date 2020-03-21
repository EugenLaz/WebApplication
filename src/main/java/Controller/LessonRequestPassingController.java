package Controller;


import Services.Data.impl.LessonRequestDaoServiceImpl;
import Services.Data.impl.UserDaoServiceImpl;
import entity.LessonRequest;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@RestController
public class LessonRequestPassingController {

    @Autowired
    LessonRequestDaoServiceImpl lessonDao;
    @Autowired
    UserDaoServiceImpl userDao;


    @RequestMapping(value = "/sendRequest/*")
    public ModelAndView parseRequest(HttpServletRequest request) {
        LessonRequest lessonRequest = new LessonRequest();
        String tutorID = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1);
        User user = (User) request.getSession().getAttribute("user");
        lessonRequest.setPricePerHour(Integer.valueOf(request.getParameter("price")));
        lessonRequest.setPlace(request.getParameter("place"));
        lessonRequest.setMessage(request.getParameter("description"));
        lessonRequest.setDate(Date.valueOf(request.getParameter("date")));
        Time time;
        String sTime = request.getParameter("time");
        time = Time.valueOf(LocalTime.parse(sTime));
        lessonRequest.setTime(time);
        lessonRequest.setStudentID(
                ((User) request.getSession().getAttribute("user")).getUsername());
        lessonRequest.setTutuorID(tutorID);
        lessonDao.saveLessonRequest(lessonRequest);

        return new ModelAndView("/view/protected/Student/ReviewTutorPage");
    }


    private void processPayment(User user, User tutor){

    }

}
