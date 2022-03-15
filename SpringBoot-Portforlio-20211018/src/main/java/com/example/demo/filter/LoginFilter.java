package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Investor;
import com.example.demo.repository.InvestorRepository;

@WebFilter("/*")
public class LoginFilter extends BaseFilter {
	
	@Autowired
	private InvestorRepository investorRepository;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession httpSession = request.getSession();

		if (request.getParameter("investor_id") != null) {
			int id  = Integer.parseInt( request.getParameter("investor_id") );
			Investor investor = investorRepository.findById(id).get();
			httpSession.setAttribute("investor_id", investor.getId());
			httpSession.setAttribute("investor_username", investor.getUsername());
			httpSession.setAttribute("watch_id", investor.getWatchs().iterator().next().getId());
			httpSession.setAttribute("investor", investor);
		}

		chain.doFilter(request, response);
	}
}
