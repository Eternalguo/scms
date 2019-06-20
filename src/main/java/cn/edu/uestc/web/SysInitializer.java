package cn.edu.uestc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author :glb
 * @date :Created in 20:11 2019/6/14
 * @discription :the web initializer
 */
public class SysInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        String systemName = application.getInitParameter("systemName");
        application.setAttribute("systemName", systemName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
