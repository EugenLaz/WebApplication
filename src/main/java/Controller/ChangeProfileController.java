package Controller;


import Config.Security.MyUserDetails;
import Services.impl.UserServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
public class ChangeProfileController {

    @Autowired
    UserServiceImpl dao;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/loadPage")
    public ModelAndView loadStuff() {
        User user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        ModelAndView mav = new ModelAndView("view/ProfileChange");
        System.out.println("working");
        mav.addObject(user);
        return mav;
    }

    @RequestMapping(value = "/changesProcess", method = RequestMethod.GET)
    public ModelAndView processData(@RequestParam(name = "Name") String name, @RequestParam("Email") String email,
                                    @RequestParam(name = "Password") Object password) {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = dao.getByUserName(username).get();
        user.setPassword((String) password);
        user.setEmail(email);
        user.setName(name);
        dao.saveUser(user);
        user = dao.getByUserName(username).get();
        ModelAndView modelAndView = new ModelAndView("view/ProfileChange");
        modelAndView.addObject(user);
        return loadStuff();
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String realPathtoUploads = request.getServletContext().getRealPath("/resources/profilePictures/");
            if (!new File(realPathtoUploads).exists()) {
                new File(realPathtoUploads).mkdir();
            }
            String filePath = realPathtoUploads
                                + ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()+".png";
            File dest = new File(filePath);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return loadStuff();
    }

}
