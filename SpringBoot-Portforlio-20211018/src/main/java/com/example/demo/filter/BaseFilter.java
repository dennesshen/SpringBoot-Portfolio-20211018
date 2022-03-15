package com.example.demo.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;


public class BaseFilter extends HttpFilter{

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

}
