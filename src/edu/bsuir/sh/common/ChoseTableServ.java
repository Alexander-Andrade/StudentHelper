package edu.bsuir.sh.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bsuir.sh.beans.UserBean;

import java.util.*;


public class ChoseTableServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> tableServletsNames;
  
	private void fillTablesServletsMap(){
	    	tableServletsNames = new HashMap<String, String>();
	    	tableServletsNames.put("groups",    "/GroupsServ");
	    	tableServletsNames.put("users",     "/UsersServ" );
	    	tableServletsNames.put("students",  "/StudentsServ" );
	    	tableServletsNames.put("marks",     "/MarksServ");
	    	tableServletsNames.put("studies",   "/StudiesServ" );
	    	tableServletsNames.put("professors","/ProfessorsServ");
	}
	
    public ChoseTableServ() {
        super();
        fillTablesServletsMap();
    }
    
    private String getSelectedTableServ(String button_key) {
		return tableServletsNames.get(button_key);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleChoise(request, response);
	}
	
	protected void  handleChoise(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String tableLabel = request.getParameter("table");
		String tableServName = getSelectedTableServ(tableLabel) ;
		request.getRequestDispatcher(tableServName).forward(request, response);
	}

}
