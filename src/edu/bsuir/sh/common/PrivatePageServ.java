package edu.bsuir.sh.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrivatePage
 */
//@WebServlet("/PrivatePage")
public class PrivatePageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrivatePageServ() {
        super();
    }
    
    protected void generateResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("data", "we are on private page!");
    	request.getRequestDispatcher("helloUser.jsp").forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generateResponse(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generateResponse(request,response);
	}

}
