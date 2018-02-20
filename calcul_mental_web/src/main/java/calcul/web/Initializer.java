package calcul.web;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.pw06.core.config.AppConfig;
import yncrea.pw06.core.config.DBConfig;
import yncrea.pw06.web.config.WSConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import calcul.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        Dynamic servlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/calcul/*");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {AppConfig.class,DBConfig.class, WSConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { "/web/" };
    }
}
