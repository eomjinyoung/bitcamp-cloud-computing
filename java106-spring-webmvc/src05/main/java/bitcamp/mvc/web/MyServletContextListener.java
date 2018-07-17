package bitcamp.mvc.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized().......");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed()........");
    }
}
