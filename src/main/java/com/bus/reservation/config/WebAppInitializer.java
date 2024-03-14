package com.bus.reservation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
		webAppContext.register(AppConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
		ServletRegistration.Dynamic customServlet = servletContext.addServlet("busReservationDispatcher",
				dispatcherServlet);
		customServlet.setLoadOnStartup(1);
		customServlet.addMapping("/");
	}

}
