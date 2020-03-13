package Controller;


import Config.Security.MyUserDetails;
import Services.impl.UserDaoServiceImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class ChangeProfileController {

    @Autowired
    private UserDaoServiceImpl dao;
    @Autowired
    private HttpServletRequest request;

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    @RequestMapping(value = "/loadChangePage")
    public ModelAndView loadStuff() {
        User user = dao.getByUserName(((User) request.getSession().getAttribute("user")).getUsername()).get();
        ModelAndView mav = new ModelAndView("view/ProfileChange");
        mav.addObject(user);
        return mav;
    }

    @RequestMapping(value = "/changesProcess", method = RequestMethod.GET)
    public ModelAndView processData() {
        String username = ((MyUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getUsername();
        User user = dao.getByUserName(username).get();
        user.setPassword(request.getParameter("Password"));
        user.setEmail(request.getParameter("Email"));
        user.setName(request.getParameter("Name"));
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
            String realPathtoUploads = request.getServletContext().getRealPath("/web-resources/profilePictures/");
            if (!new File(realPathtoUploads).exists()) {
                new File(realPathtoUploads).mkdir();
            }
            String filePath = realPathtoUploads
                    + ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername() + ".png";
            File resulted = new File(filePath);
            try {
                file.transferTo(resulted);
                BufferedImage image = ImageIO.read(resulted);
                BufferedImage resized = resize(image, 200, 200);
                ImageIO.write(resized, "png", resulted);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return loadStuff();
    }

}
