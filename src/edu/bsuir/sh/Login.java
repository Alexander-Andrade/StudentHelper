package edu.bsuir.sh;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
 //@WebServlet("/test")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		genResponse(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		genResponse(request, response);
	}
	private void genResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//map
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		//String password = request.getParameter("password");
		//param user set to the session
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("password", password);
		
		request.getRequestDispatcher("ChoseTable.jsp").forward(request, response);
	}

	
	
}
