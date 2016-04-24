package edu.bsuir.sh.dao;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.cci.ResultSet;
import sun.jdbc.odbc.ee.DataSource;

public abstract class AbstractDAO<T> {

	protected Connection getConnection(){
		try{
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY,
			"com.ibm.websphere.naming.WsnInitialContextFactory");
			InitialContext context = new InitialContext(env);
			context.lookup("jdbc/studentDB");
			DataSource source = (DataSource)context.lookup("jdbc/StudentDB");
			return source.getConnection();
		}catch(NamingException e){
			throw new RuntimeException(e);
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	protected abstract T get(String id) throws DBException;
	protected abstract List<T> getAll() throws DBException;
	protected abstract void save(T t) throws DBException;
	protected abstract void delete(T t) throws DBException;
	protected abstract void update(T t) throws DBException ;
	
	/*
	//beans not String
	protected List<T> getAll(){
		Connection connection = null;
		List<T> list = new ArrayList<T>();
		try{
			connection = getConnection();
			//умеет отсылать на базу запрос, SQL ? - подстановка
			PreparedStatement statement = connection.prepareStatement("Select \"USER\", PASSWORD, ROLE " + "FROM USERS WHERE PASSWORD = ?");
			statement.setString(1, "1");
			ResultSet set = (ResultSet)statement.executeQuery();
			while (set.next()){
				//new bean!!!!
				String user = set.getString("USER");
				//заполнить
				list.add(user);
			}
			return list;
		}catch(SQLException e){
			new RuntimeException(e);
		}finally{
			if(connection != null)
				try{connection.close();}catch(SQLException ignore){}
		}
		return list;
	}
	*/
}
