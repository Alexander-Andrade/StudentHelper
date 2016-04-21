package edu.bsuir.sh.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.bsuir.sh.TablePages;
import edu.bsuir.sh.TableType;
import edu.bsuir.sh.beans.*;
import edu.bsuir.*;

//@WebServlet("/ChoseBrowseOrEdit")
public class ChoseTableAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChoseTableAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkRightsAndRedirect(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkRightsAndRedirect(request, response);
	}
	
	void checkRightsAndRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pages for 
		TablePages tablePages = (TablePages)request.getSession().getAttribute("table_pages");
		//radio buttons (browsable, editable)
		TableType selTableType = (TableType)request.getSession().getAttribute("table_type");
		String tableLabel = (String)request.getSession().getAttribute("table_label");
		User user = (User)request.getSession().getAttribute("user");
		/*
		if(hasUserPermission(user, tableLabel))
				request.getRequestDispatcher(tablePages.getEditablePage()).forward(request, response);
			else
				request.getRequestDispatcher("AccessDenied.jsp").forward(request, response);
		}
		else //anyone can browse tables 
			request.getRequestDispatcher(tablePages.getBrowseablePage()).forward(request, response);
		*/
	}
	
	protected boolean hasUserPermission(User user, String tableLabel){
		//admin can do anything
		if(user.getRole() == Role.Admin)
			return true;
		else if(user.getRole() == Role.Teacher && tableLabel.equals("marks"))
			return true;
		return false;
	}
	
	
}
