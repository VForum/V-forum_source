package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.integrate.ConnectionManager;
import com.vforum.model.LoginModel;
//import com.vforum.model.ViewProfileModel;

public class EmployeesDAOImpl implements EmployeesDAO {

	@Override
	public boolean storeEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			Connection connection=ConnectionManager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("insert into employees_info values(?,?,?,?,?,?,?,?)");
			statement.setString(1,employees.getEmployeeUid());
			statement.setString(2,employees.getFirstName());
			statement.setString(3, employees.getLastName());
			statement.setString(4, employees.getEmail());
			statement.setString(5,employees.getPhoneNumber());
			statement.setString(6,employees.getDesignation());
			int rows1=statement.executeUpdate();
			PreparedStatement statement1=
					connection.prepareStatement("insert into user_credentials values(?,?,'EMPLOYEE')");
			statement1.setString(1,employees.getEmployeeUid());
			statement1.setString(2,employees.getPassword());
			int rows2=statement.executeUpdate();
			ConnectionManager.closeConnection();
			
			if(rows1>0 && rows2>0)
				return true;
			else
				return false;
		} 
	
	@Override
	public List<Posts> getAllQuestions() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from posts");
		
		List<Posts> postList=new ArrayList<Posts>();
		while(resultSet.next()) {
			Posts post=new Posts();
			post.setUserId(resultSet.getString("p_username"));
			post.setPostId(resultSet.getInt("post_id"));
			post.setPost(resultSet.getString("post"));
			post.setCategory(resultSet.getString("title"));
			postList.add(post);
		}
		ConnectionManager.closeConnection();

		return postList;
	}
}

