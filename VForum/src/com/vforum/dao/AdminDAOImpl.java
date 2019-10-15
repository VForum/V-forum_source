package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.integrate.ConnectionManager;

public class AdminDAOImpl implements AdminDAO{
	Logger logger=Logger.getLogger(AdminDAOImpl.class.getName());
	@Override
	public List<Employees> getEmployeeDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In AdminDAOImpl getEmployeeDetails method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- In getEmployeeDetails method of AdminDAOImpl class the database connection opened---");
		Statement statement=connection.createStatement();
		logger.info("---- retrieving employees data from database ---- ");
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
			logger.info("----  Employees data retrieved from database sucessfully ---- ");
		}
		ConnectionManager.closeConnection();
		logger.info("---- In getEmployeeDetails method of AdminDAOImpl class the database connection closed---");
		logger.info("---- In AdminDAOImpl getEmployeeDetails method completed ---- ");
		return employeesList;
		

	}
	@Override
	public List<Posts> getAllQuestions() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In AdminDAOImpl getAllQuestions method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- In getAllQuestions method of AdminDAOImpl class the database connection opened---");
		Statement statement=connection.createStatement();
		logger.info("---- retrieving questions data from database ---- ");
		ResultSet resultSet=
				statement.executeQuery("select * from questions");
		
		List<Posts> postList=new ArrayList<Posts>();
		while(resultSet.next()) {
			Posts post=new Posts();
			post.setUserId(resultSet.getString("p_username"));
			post.setPostId(resultSet.getInt("post_id"));
			post.setPost(resultSet.getString("post"));
			post.setCategory(resultSet.getString("title"));
			postList.add(post);
			logger.info("----  Questions data retrieved from database sucessfully ---- ");
		}
		ConnectionManager.closeConnection();
		logger.info("---- In getAllQuestions method of AdminDAOImpl class the database connection closed---");
		logger.info("---- In AdminDAOImpl getAllQuestions method completed ---- ");
		return postList;
	}
	@Override
	public boolean deleteQuestion(int postId) throws ClassNotFoundException, SQLException {
		logger.info("---- In AdminDAOImpl deleteQuestion method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- In deleteQuestion method of AdminDAOImpl class the database connection opened---");
		PreparedStatement statement=
				connection.prepareStatement("delete from questions where post_id=?");
		statement.setInt(1,postId);
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		logger.info("---- In deleteQuestion method of AdminDAOImpl class the database connection closed---");
		logger.info("---- In AdminDAOImpl deleteQuestion method completed ---- ");
		if(rows>0)
			return true;
		else
		return false;
	}
}

	

