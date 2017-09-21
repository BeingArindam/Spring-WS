package com.cts.ws;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
		dispatcherServlet.setApplicationContext(ctx);
		dispatcherServlet.setTransformWsdlLocations(true);

		Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
		dynamic.addMapping("/*");
		dynamic.setLoadOnStartup(1);
	}

}
