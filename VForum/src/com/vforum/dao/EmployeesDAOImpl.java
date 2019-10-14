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

public class EmployeesDAOImpl implements EmployeesDAO {

	@Override
	public boolean storeEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			Connection connection=ConnectionManager.openConnection();
			PreparedStatement statementEmployeesInfo=
					connection.prepareStatement("insert into employees_info values(?,?,?,?,?,?,?)");
			statementEmployeesInfo.setString(1,employees.getEmployeeUid());
			statementEmployeesInfo.setString(2,employees.getFirstName());
			statementEmployeesInfo.setString(3, employees.getLastName());
			statementEmployeesInfo.setString(4, employees.getEmail());
			statementEmployeesInfo.setString(5,employees.getPhoneNumber());
			statementEmployeesInfo.setString(6,employees.getDesignation());
			statementEmployeesInfo.setString(7,employees.getDob());
			int rows1=statementEmployeesInfo.executeUpdate();
			PreparedStatement statementUserCredentials=
					connection.prepareStatement("insert into user_credentials values(?,?,'EMPLOYEE')");
			statementUserCredentials.setString(1,employees.getEmployeeUid());
			statementUserCredentials.setString(2,employees.getPassword());
			int rows2=statementUserCredentials.executeUpdate();
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

	@Override
	public List<Employees> getProfile() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employees_info");
		
		List<Employees> employeesList=new ArrayList<Employees>();
		while(resultSet.next()) {
			Employees employees=new Employees();
			employees.setEmployeeUid(resultSet.getString("employee_uname"));
			employees.setFirstName(resultSet.getString("first_name"));
			employees.setLastName(resultSet.getString("last_name"));
			employees.setEmail(resultSet.getString("email"));
			employees.setPhoneNumber(resultSet.getString("phone_number"));
			employees.setDesignation(resultSet.getString("designation"));
			employees.setDob(resultSet.getString("dob"));
			employeesList.add(employees);
		}
		ConnectionManager.closeConnection();
		return employeesList;
	}
}

