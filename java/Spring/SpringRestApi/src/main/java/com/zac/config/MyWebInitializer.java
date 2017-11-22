package com.zac.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		try {
			AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
			ctx.register(MyWebMvcConfigurer.class);
			ctx.setServletContext(container);

			DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
			dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
			ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", dispatcherServlet);

			servlet.setLoadOnStartup(1);
			servlet.addMapping("/");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}