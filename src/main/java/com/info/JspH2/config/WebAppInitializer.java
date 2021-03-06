package com.info.JspH2.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	
	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// TODO Auto-generated method stub
	
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		rootContext.register(PersistenceContext.class);
		
		servletContext.addListener( new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(WebAppContext.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping("/");
		
		
		
		
	}

}
