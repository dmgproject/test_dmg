package com.dmg.jsp.member.encypt;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {


    public LoginFilter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		
		request.setAttribute("originPwd", req.getParameter("userPwd"));
		
		LoginWrapper lw = new LoginWrapper(req);
		
		chain.doFilter(lw, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
