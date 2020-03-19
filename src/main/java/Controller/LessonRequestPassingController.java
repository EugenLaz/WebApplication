package Controller;


import Services.Data.LessonRequestDaoService;
import Services.Data.impl.LessonRequestDaoServiceImpl;
import entity.LessonRequest;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class LessonRequestPassingController {

    @Autowired
    LessonRequestDaoServiceImpl dao;

    @RequestMapping(value = "/sendRequest/*")
    public ModelAndView parseRequest(HttpServletRequest request) {
        LessonRequest lessonRequest = new LessonRequest();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");


        lessonRequest.setPricePerHour(Integer.valueOf(request.getParameter("price")));
        lessonRequest.setPlace(request.getParameter("place"));
//        lessonRequest.setDateTime(LocalDateTime.parse(request.getParameter("dateTime")));
        lessonRequest.setMessage(request.getParameter("description"));
        lessonRequest.setDate(Date.valueOf(request.getParameter("date")));
        Time time;
        String sTime = request.getParameter("time");
        time = Time.valueOf(LocalTime.parse(sTime));
        lessonRequest.setTime(time);
        lessonRequest.setStudentID(
                ((User) request.getSession().getAttribute("user")).getUsername());
        lessonRequest.setTutuorID(request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1));
        dao.saveLessonRequest(lessonRequest);

        return new ModelAndView("view/protected/Student/TutorsList");
    }

}
