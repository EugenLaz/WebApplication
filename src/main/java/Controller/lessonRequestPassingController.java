package Controller;


import Config.Security.MyUserDetails;
import entity.Lesson;
import entity.LessonRequest;
import entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class lessonRequestPassingController {
    @RequestMapping(value = "/requests")
    public ModelAndView openRequestPage(){
        return new ModelAndView("view/Student/SendLessonRequest");
    }

    @RequestMapping(value = "/sendRequest",method = RequestMethod.GET)
    public void parseRequest(HttpServletRequest request){
        LessonRequest lessonRequest = new LessonRequest();
        lessonRequest.setPricePerHour(Integer.valueOf(request.getParameter("price")));
        lessonRequest.setPlace(request.getParameter("place"));
        lessonRequest.setDateTime(LocalDateTime.parse(request.getParameter("dateTime")));
        lessonRequest.setMessage(request.getParameter("description"));

        lessonRequest.setStudentID(
                ((User)request.getSession().getAttribute("user")).getUsername());
        lessonRequest.setTutuorID(request.getParameter("tutor"));
        System.out.println(lessonRequest.toString());
    }

}
