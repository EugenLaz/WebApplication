package Config.Web;

import Services.Security.impl.BCryptPasswordEncodingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"Controller", "Config", "Services", "entity"})
public class ConfigWeb implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("view/LoginPage");
        registry.addViewController("/start").setViewName("index");
        registry.addViewController("/protected/schedule").setViewName("view/protected/Schedule");
        registry.addViewController("/protected/loadProfile").setViewName("view/protected/ProfileChange");
        registry.addViewController("/student/tutorReview").setViewName("view/protected/Student/ReviewTutorPage");
        registry.addViewController("/student/tutorsList").setViewName("view/protected/Student/TutorsList");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/profilePictures/**").addResourceLocations("file:///${fullPath}/web-resources/profilePictures/");

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncodingServiceImpl();
    }


}
