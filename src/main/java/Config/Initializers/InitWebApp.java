package Config.Initializers;

import Config.Other.DataConfig;
import Config.Other.MailConfig;
import Config.Security.ConfigSecurity;
import Config.Web.ConfigWeb;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

public class InitWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ConfigWeb.class, DataConfig.class, ConfigSecurity.class, MailConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // upload temp file will put here
        File uploadDirectory = new File("C:\\Users\\Евгений\\Desktop\\upload");

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        30000000, 30000000 * 2, 30000000 / 2);

        registration.setMultipartConfig(multipartConfigElement);
        System.out.println("worked");
    }

}
