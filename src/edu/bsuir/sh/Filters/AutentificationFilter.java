package edu.bsuir.sh.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bsuir.sh.beans.UserBean;

public class AutentificationFilter implements Filter {

    public AutentificationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpServletRequest request = (HttpServletRequest)req;
		
		String url = request.getRequestURI();
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		
		if(url.contains(".")){
			chain.doFilter(request, response);
		}else if(url.endsWith("Login")){	//if login page
			chain.doFilter(request, response);
		}else if(user != null){// if user and it's session
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("WelcomPage.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
