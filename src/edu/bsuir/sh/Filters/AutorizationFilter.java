package edu.bsuir.sh.Filters;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
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

import edu.bsuir.sh.beans.UserBean;

public class AutorizationFilter implements Filter {
	private ArrayList<String> accessList;
    public AutorizationFilter() {
    	accessList = new ArrayList<String>();
    	fillAccessByRoleList();
    }
    private void fillAccessByRoleList(){
    	accessList.add("admin");
    	accessList.add("professor");
    }
    private boolean hasRoleAccess(String role){
    	return accessList.contains(role.toLowerCase());
    }
	public void destroy() {
	}
		
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpServletRequest request = (HttpServletRequest)req;
	
		String url = request.getRequestURI();
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		if (hasRoleAccess(user.getRole()) || url.endsWith(".css") || url.endsWith(".jsp")){
			chain.doFilter(request, response);
		}
		else{
			response.sendRedirect("AccessDenied.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
