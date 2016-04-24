package edu.bsuir.sh.common;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.bsuir.sh.beans.UserBean;

public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		login(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(); 
		
		UserBean user = new UserBean();
		user.setName(userName);
		user.setPassword(password);
		//get role from the db!!!!!!!!!!!!!!!!!
		user.setRole("admin");
		
		session.setAttribute("user", user);
		request.getRequestDispatcher("ChoseTable.jsp").forward(request, response);
	}	
}
