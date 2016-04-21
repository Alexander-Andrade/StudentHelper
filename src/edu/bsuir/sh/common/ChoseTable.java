package edu.bsuir.sh.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import edu.bsuir.sh.TablePages;

public class ChoseTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, TablePages> tables_servlets;
  
	private void fillTablesServletsMap(){
	    	tables_servlets = new HashMap<String, TablePages>();
	    	tables_servlets.put("groups", new TablePages("/GroupView", "/GroupEdit") );
	    	tables_servlets.put("users", new TablePages("/UsersView", "/UsersEdit") );
	    	tables_servlets.put("students", new TablePages("/StudentsView", "/StudentsEdit") );
	    	tables_servlets.put("marks", new TablePages("/MarksView", "/MarksEdit"));
	    	tables_servlets.put("studies", new TablePages("/StudiesView", "/StudiesEdit") );
	    	tables_servlets.put("professors", new TablePages("/ProfessorsView", "/ProfessorsEdit") );
	}
	
    public ChoseTable() {
        super();
        fillTablesServletsMap();
    }
    
    private TablePages getSelectedTablePages(String button_key) {
		return tables_servlets.get(button_key);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleChoise(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleChoise(request, response);
	}
	
	protected void  handleChoise(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String tableLabel = request.getParameter("table");
		TablePages table = getSelectedTablePages(tableLabel) ;
		request.getSession().setAttribute("table_label", tableLabel);
		request.getSession().setAttribute("table_pages", table);
		request.getRequestDispatcher("ChoseTableAction").forward(request, response);
	}

}
