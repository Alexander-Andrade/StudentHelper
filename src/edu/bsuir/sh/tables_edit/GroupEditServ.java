package edu.bsuir.sh.tables_edit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bsuir.sh.beans.GroupBean;

//@WebServlet("/GroupEditServ")
public class GroupEditServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GroupEditServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writeEditedGroupToDB(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writeEditedGroupToDB(request, response);
	}
	
	private void writeEditedGroupToDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//make a new query to the server
		//and return it
		GroupBean gr1 = new GroupBean();
		gr1.setGroupNumber("35");
		gr1.setAvgMark(8.3);
		
		ArrayList<GroupBean> groups = new ArrayList<GroupBean>();
		groups.add(gr1);
		
		String oper = (String)request.getParameter("oper");
		System.out.println(oper);
		//send this bean to the db
		GroupBean group = new GroupBean();
		group.setGroupNumber((String)request.getParameter("group_number"));
		group.setAvgMark(Double.parseDouble((String)request.getParameter("avg_mark")));

		System.out.println(group.getGroupNumber());
		System.out.println(group.getAvgMark());
		//make new request to the db
		
		request.setAttribute("groups", groups);
		request.getRequestDispatcher("/GroupsTable.jsp").forward(request, response);
	}

}
