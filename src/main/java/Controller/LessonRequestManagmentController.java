package Controller;

import Services.Data.impl.LessonRequestDaoServiceImpl;
import entity.LessonRequest;
import entity.LessonRequestStatus;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

public class LessonRequestManagmentController {
    @Autowired
    private LessonRequestDaoServiceImpl dao;

    @RequestMapping("/acceptRequest/{id}")
    public ModelAndView acceptRequest(@PathVariable("id") int id, HttpServletRequest request) {
        dao.changeStatus(id, LessonRequestStatus.Approved);
        return loadRequests(request);
    }

    @RequestMapping("/declineRequest/{id}")
    public ModelAndView declineRequest(@PathVariable("id") int id, HttpServletRequest request) {
        dao.changeStatus(id, LessonRequestStatus.Rejected);
        return loadRequests(request);
    }

    @RequestMapping(value = "/loadRequests")
    public ModelAndView loadRequests(HttpServletRequest request) {
        String loggedUser = ((User) request.getSession().getAttribute("user"))
                .getUsername();
        List<LessonRequest> lessonRequests;
        lessonRequests = dao.findByUser(loggedUser);
        ModelAndView mav = new ModelAndView("view/protected/MyRequest");
        mav.addObject("requests", lessonRequests);
        return mav;
    }

}
