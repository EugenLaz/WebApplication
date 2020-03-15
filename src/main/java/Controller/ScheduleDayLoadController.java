package Controller;

//import DAO.LessonDaoImpl;
import Services.Data.impl.LessonDaoServiceImpl;
import entity.Lesson;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@RestController
public class ScheduleDayLoadController  {

    @Autowired
    private LessonDaoServiceImpl service;


    @RequestMapping(value = "/scheduleProcess",method = RequestMethod.GET)
    public ModelAndView getLessons(@RequestParam(name = "chosenDate") Object objct) {
        List<Lesson> result = service.getByDate(Date.valueOf((String) objct));
        result.sort(Comparator.comparing(Lesson::getTime));
        ModelAndView modelAndView = new ModelAndView("view/Schedule");
        modelAndView.addObject("objects",result);

        return modelAndView;
    }


}
