package it.scp.spring.autowiring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("SCP WebApplicationInitializer");

        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(SpringConfig.class);
        annotationConfigWebApplicationContext.setServletContext(servletContext);
        annotationConfigWebApplicationContext.refresh();

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(annotationConfigWebApplicationContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

    }

}