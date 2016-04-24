package edu.bsuir.sh.tables;
import edu.bsuir.sh.beans.GroupBean;
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

public class GroupsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GroupsServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getGroupList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getGroupList(request, response);
	}
	
	void getGroupList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupBean gr1 = new GroupBean();
		gr1.setGroupNumber("1234");
		gr1.setAvgMark(9.5);
		
		GroupBean gr2 = new GroupBean();
		gr2.setGroupNumber("5435");
		gr2.setAvgMark(6.7);
		
		GroupBean gr3 = new GroupBean();
		gr3.setGroupNumber("35");
		gr3.setAvgMark(8.3);
		
		ArrayList<GroupBean> groups = new ArrayList<GroupBean>();
		groups.add(gr1);
		groups.add(gr2);
		groups.add(gr3);
		
		request.setAttribute("groups", groups);
		request.getRequestDispatcher("/GroupsTable.jsp").forward(request, response);
	}
	
	private void sendJsonList(HttpServletRequest request, HttpServletResponse response, ArrayList<GroupBean> groups) throws ServletException, IOException {
		String jsonGroups = new Gson().toJson(groups);
		System.out.println(jsonGroups);
		//request.setAttribute("json_array", json_db_str);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonGroups);
		response.sendRedirect("DrawTable.jsp");
	}
}
