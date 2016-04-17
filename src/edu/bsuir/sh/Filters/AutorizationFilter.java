package edu.bsuir.sh.Filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizationFilter implements Filter {
	
    public AutorizationFilter() {
    }

	public void destroy() {
	}
		
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpServletRequest request = (HttpServletRequest)req;
		
		System.out.println("autorization filter!!!");
		System.out.println(request.getRequestURI() + "autority filter");
		
		String user = (String)request.getSession().getAttribute("user");
		System.out.println(user);
		String password = (String)request.getSession().getAttribute("password");
		System.out.println(password);
		
		if(user.endsWith("admin") || user.endsWith("teacher")){	//css jsp -> pass
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		else{
			response.sendRedirect("AccessDenied.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
