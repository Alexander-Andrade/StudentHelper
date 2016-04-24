package edu.bsuir.sh.dao;

import edu.bsuir.sh.dao.AbstractDAO;
import edu.bsuir.sh.beans.UserBean;

import java.util.*;
import edu.bsuir.sh.dao.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.ResultSet;

public class UserDAO extends AbstractDAO<UserBean>{
	@Override
	protected UserBean get(String password) throws DBException{
		Connection connection = null;
		try{
			connection = getConnection();
			//умеет отсылать на базу запрос, SQL ? - подстановка
			PreparedStatement statement = connection.prepareStatement("Select \"USER\", PASSWORD, ROLE " + "FROM USERS WHERE PASSWORD = ?");
			statement.setString(1,password );
			ResultSet set = statement.executeQuery();
			//new bean!!!!
			UserBean user = new UserBean();
			user.setName(set.getString("\"USER\""));
			user.setPassword(set.getString("PASSWORD"));
			user.setRole(set.getString("ROLE"));
			return user;
		}catch(SQLException e){
			throw new DBException("fail to get GroupBean (get method)");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	
	@Override
	public List<UserBean> getAll(){
		Connection connection = null;
		List<UserBean> list = new ArrayList<UserBean>();
		try{
			connection = getConnection();
			//умеет отсылать на базу запрос, SQL ? - подстановка
			PreparedStatement statement = connection.prepareStatement("Select \"USER\", PASSWORD, ROLE " + "FROM USERS");
			ResultSet set = statement.executeQuery();
			while (set.next()){
				//new bean!!!!
				UserBean user = new UserBean();
				user.setName(set.getString("\"USER\""));
				user.setPassword(set.getString("PASSWORD"));
				user.setRole(set.getString("ROLE"));
				list.add(user);
			}
			return list;
		}catch(SQLException e){
			new DBException("fail to get users");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
		return list;
	}
	
	@Override
	public void save(UserBean user){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (\"USER\", PASSWORD, ROLE) VALUES(?,?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to insert group");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	@Override
	public void delete(UserBean user){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE \"USER\" = ?");
			statement.setString(1, user.getName());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to delete user");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}
	@Override
	public void update(UserBean user){
		Connection connection = null;
		try{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE USERS SET PASSWORD = ?, ROLE = ? WHERE \"USER\" = ?");
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getRole());
			ResultSet set = statement.executeQuery();
		}catch(SQLException e){
			new DBException("fail to update user");
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
	}

}
