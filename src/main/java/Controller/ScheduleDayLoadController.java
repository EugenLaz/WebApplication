package Controller;

//import DAO.LessonDaoImpl;

import Services.Data.impl.LessonRequestDaoServiceImpl;
//import org.springframework.security.core.context.SecurityContextHolder;
import entity.LessonRequest;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@RestController
public class ScheduleDayLoadController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private LessonRequestDaoServiceImpl dao;

    @RequestMapping(value = "/protected/scheduleProcess")
    public ModelAndView getLessons(@RequestParam(name = "chosenDate") String choosenDate) {
        Date date = Date.valueOf(choosenDate);
        ModelAndView modelAndView = new ModelAndView("view/protected/Schedule");
        List<LessonRequest> result = dao.findAllApprovedByDate(((User) request.getSession().getAttribute("user")).getUsername(), date);
        result.sort(Comparator.comparing(LessonRequest::getDate));
        System.out.println(result.toString());
        modelAndView.addObject("lessons", result);

        return modelAndView;
    }


}
