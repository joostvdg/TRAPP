package org.jiji.trapp.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApp implements WebApplicationInitializer
{

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        rootContext.setServletContext(servletContext);
        String[] configurationResources = { "classpath:/database-beans.xml" };
        rootContext.setConfigLocations(configurationResources);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        DelegatingFilterProxy delegationFilterProxy2 = new DelegatingFilterProxy(new CrossDomainFilter());
        servletContext.addFilter("filter_chain", delegationFilterProxy2).addMappingForUrlPatterns(null, false, "/");

        final AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.setServletContext(servletContext);
        webApplicationContext.register(WebMvcConfiguration.class);

        final Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

    /*
     * // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
      rootContext.register(AppConfig.class);

      // Manage the lifecycle of the root application context
      container.addListener(new ContextLoaderListener(rootContext));

      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
     */

}