package edu.bsuir.sh.dao;
import edu.bsuir.sh.dao.AbstractDAO;
import edu.bsuir.sh.beans.GroupBean;
import java.util.*;
import edu.bsuir.sh.dao.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.ResultSet;

public class GroupDAO extends AbstractDAO<GroupBean>{
	
	@Override
	protected GroupBean get(String groupNumber) throws DBException{
		Connection connection = null;
		try{
			connection = getConnection();
			//умеет отсылать на базу запрос, SQL ? - подстановка
			PreparedStatement statement = connection.prepareStatement("Select AVG_MARK " + "FROM GROUPS" + 
			"WHERE GroupBean_NUMBER = ?");
			statement.setString(1, groupNumber );
			ResultSet set = statement.executeQuery();
			//new bean!!!!
			GroupBean group = new GroupBean();
			group.setGroupNumber(groupNumber);
			group.setAvgMark(set.getDouble("AVG_MARK"));
			return group;
		}catch(SQLException e){
			throw new DBException("fail to get GroupBean (get method)");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	
	@Override
	public List<GroupBean> getAll(){
		Connection connection = null;
		List<GroupBean> list = new ArrayList<GroupBean>();
		try{
			connection = getConnection();
			//умеет отсылать на базу запрос, SQL ? - подстановка
			PreparedStatement statement = connection.prepareStatement("Select GROUP_NUMBER, AVG_MARK " + "FROM GROUPS");
			ResultSet set = statement.executeQuery();
			while (set.next()){
				//new bean!!!!
				GroupBean group = new GroupBean();
				group.setGroupNumber(set.getString("GROUP_NUMBER"));
				group.setAvgMark(set.getDouble("AVG_MARK"));
				//заполнить
				list.add(group);
			}
			return list;
		}catch(SQLException e){
			new DBException("fail to get GroupBean (get method)");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
		return list;
	}
	
	@Override
	public void save(GroupBean group){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO GROUPS (GROUP_NUMBER, AVG_MARK) VALUES(?,?)");
			statement.setString(1, group.getGroupNumber());
			statement.setDouble(2, group.getAvgMark());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to insert group");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	@Override
	public void delete(GroupBean group){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM GROUPS WHERE GROUP_NUMBER = ?");
			statement.setString(1, group.getGroupNumber());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to delete group");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	@Override
	public void update(GroupBean group){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE GROUPS SET AVG_MARK = ? WHERE GROUP_NUMBER = ?");
			statement.setDouble(1, group.getAvgMark());
			statement.setString(2, group.getGroupNumber());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to update group");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	
}
