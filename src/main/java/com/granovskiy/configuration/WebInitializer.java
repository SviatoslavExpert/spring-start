package com.granovskiy.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container)throws ServletException {
            AnnotationConfigWebApplicationContext context
            =new AnnotationConfigWebApplicationContext();
            context.setConfigLocation("com.granovskiy.configuration");  //app.config

            container.addListener(new ContextLoaderListener(context));

            ServletRegistration.Dynamic dispatcher=container
            .addServlet("dispatcher",new DispatcherServlet(context));

            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
    }
}