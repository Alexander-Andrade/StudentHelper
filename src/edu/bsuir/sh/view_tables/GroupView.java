package edu.bsuir.sh.view_tables;
import edu.bsuir.sh.beans.Group;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ibm.ws.objectManager.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.*;

public class GroupView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GroupView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getGroupList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getGroupList(request, response);
	}
	
	void getGroupList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Group gr1 = new Group();
		gr1.setGroupNumber("1234");
		gr1.setAvgMark(9.5);
		
		Group gr2 = new Group();
		gr2.setGroupNumber("5435");
		gr2.setAvgMark(6.7);
		
		Group gr3 = new Group();
		gr3.setGroupNumber("35");
		gr3.setAvgMark(8.3);
		
		ArrayList<Group> group_list = new ArrayList<Group>();
		group_list.add(gr1);
		group_list.add(gr2);
		group_list.add(gr3);
		
		request.setAttribute("list", group_list);
		
		
		/*
		String json_db = new Gson().toJson(group_list);
		System.out.println(json_db);
		request.setAttribute("json_arr", json_db_str);
		//transfer json string to jsp
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json_db);
		//transition to the table drawing!!!!!!!!not here
		response.sendRedirect("draw_table.jsp");
		*/
		//? to generic table builder jsp
		request.getRequestDispatcher("/drawGroupView.jsp").forward(request, response);
	}
}
