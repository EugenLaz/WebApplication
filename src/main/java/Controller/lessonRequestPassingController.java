package Controller;


import entity.LessonRequest;
import entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class lessonRequestPassingController {


    @RequestMapping(value = "/sendRequest/*")
    public ModelAndView parseRequest(HttpServletRequest request) {
        LessonRequest lessonRequest = new LessonRequest();

        lessonRequest.setPricePerHour(Integer.valueOf(request.getParameter("price")));
        lessonRequest.setPlace(request.getParameter("place"));
        lessonRequest.setDateTime(LocalDateTime.parse(request.getParameter("dateTime")));
        lessonRequest.setMessage(request.getParameter("description"));
        lessonRequest.setStudentID(
                ((User) request.getSession().getAttribute("user")).getUsername());
        lessonRequest.setTutuorID(request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1));
        System.out.println(lessonRequest);
        return new ModelAndView("view/Student/TutorsList");
    }

}
