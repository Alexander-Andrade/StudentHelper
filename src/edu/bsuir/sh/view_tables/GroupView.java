package edu.bsuir.sh.view_tables;
import edu.bsuir.sh.beans.Group;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ws.objectManager.List;

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
		gr1.setGroup_number("1234");
		gr1.setAvg_mark(9.5);
		
		Group gr2 = new Group();
		gr2.setGroup_number("5435");
		gr2.setAvg_mark(6.7);
		
		ArrayList<Group> group_list = new ArrayList<Group>();
		group_list.add(gr1);
		group_list.add(gr2);
		
		String json_db_str = new Gson().toJson(group_list);
		System.out.println(json_db_str);
		//request.setAttribute("json_arr", json_db_str);
		
		//transfer json string to jsp
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json_db_str);
		//? to generic table builder jsp
		//request.getRequestDispatcher("/draw_table.jsp").forward(request, response);
	}
}
