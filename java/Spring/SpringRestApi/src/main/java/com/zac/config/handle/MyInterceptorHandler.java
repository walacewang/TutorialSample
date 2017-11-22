package com.zac.config.handle;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptorHandler extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(MyInterceptorHandler.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			logger.info(String.format(">>> Process start, URI=%s, Method=%s#%s", 
					request.getRequestURI(),
					handlerMethod.getMethod().getDeclaringClass().getName(),
					handlerMethod.getMethod().getName()));

		} else {
			logger.info(String.format(">>> Process start, URI=%s", request.getRequestURI()));
		}

		// dump request head info to log file for debug.
		StringBuilder headerinfo = new StringBuilder();
		Enumeration<String> enames = request.getHeaderNames();
		int iHeaderCount = 0;
		while (enames.hasMoreElements()) {
			String name = enames.nextElement();
			if (iHeaderCount != 0) {
				headerinfo.append(", ");
			}
			headerinfo.append(String.format("%s:%s", name, request.getHeader(name)));
			iHeaderCount++;
		}
		if (iHeaderCount > 0) {
			logger.info("Request Header => {" + headerinfo + "}");
		}

		return true;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("<<< Process completed, Response.status=" + response.getStatus());
	}

}
