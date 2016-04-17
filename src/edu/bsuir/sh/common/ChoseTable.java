package edu.bsuir.sh.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class ChoseTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> tables_servlets;
  
	private void fillTablesServletsMap(){
	    	tables_servlets = new HashMap<String, String>();
	    	tables_servlets.put("groups", "/GroupView");
	    	tables_servlets.put("users", "/UsersView");
	    	tables_servlets.put("students", "/StudentsView");
	    	tables_servlets.put("marks", "/MarksView");
	    	tables_servlets.put("studies", "/StudiesView");
	    	tables_servlets.put("professors", "/ProfessorsView");
	}
	
    public ChoseTable() {
        super();
        fillTablesServletsMap();
    }
    
    private String servletsNamesFactory(String button_key) {
		return tables_servlets.get(button_key);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleChoise(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleChoise(request, response);
	}
	
	protected void  handleChoise(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		/*
		System.out.println("here");
		String table_name = request.getParameter("table");
		//request.setAttribute("tables", table_name);
		System.out.println(table_name);
		String s = servletsNamesFactory(table_name) ;
		System.out.println(s);
		*/
		request.getRequestDispatcher(/*s*/ "/GroupView").forward(request, response);
	}

}
