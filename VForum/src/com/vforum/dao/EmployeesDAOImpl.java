package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vforum.entities.Answers;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.integrate.ConnectionManager;
import com.vforum.model.LoginModel;

public class EmployeesDAOImpl implements EmployeesDAO {
	Logger logger=Logger.getLogger(EmployeesDAOImpl.class.getName());
	@Override
	public boolean storeEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesDAOImpl storeEmployeeDetails method started ---- ");
			Connection connection=ConnectionManager.openConnection();
			logger.info("---- inserting employee registration data into database ---- ");
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
			statementEmployeesInfo.close();
			PreparedStatement statementUserCredentials=
					connection.prepareStatement("insert into user_credentials values(?,?,'EMPLOYEE')");
			statementUserCredentials.setString(1,employees.getEmployeeUid());
			statementUserCredentials.setString(2,employees.getPassword());
			int rows2=statementUserCredentials.executeUpdate();
			statementUserCredentials.close();
			ConnectionManager.closeConnection();
			logger.info("---- In EmployeesDAOImpl storeEmployeeDetails method completed ---- ");
			if(rows1>0 && rows2>0) {
				return true;}
			else {
				return false;}
		} 
	
	@Override
	public List<Posts> getAllQuestions() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesDAOImpl getAllQuestions method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from questions");
		statement.close();
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
		logger.info("---- In EmployeesDAOImpl getAllQuestions method completed ---- ");
		return postList;
	}

	@Override
	public List<Employees> getProfile(LoginModel loginModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesDAOImpl getProfile method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement profile=
				connection.prepareStatement("select * from employees_info where employee_uname=?");
				profile.setString(1,loginModel.getUserId());
		ResultSet resultSet=profile.executeQuery();
		profile.close();
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
		logger.info("---- In EmployeesDAOImpl getProfile method completed ---- ");
		return employeesList;
	}

	@Override
	public List<Answers> getAllAnswers(LoginModel loginModel, int postId) throws ClassNotFoundException, SQLException {
		logger.info("---- In EmployeesDAOImpl getAllAnswers method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement answers=
				connection.prepareStatement("select * from answers where a_post_id=?");
				answers.setInt(1,postId);
		ResultSet resultSet=answers.executeQuery();
		answers.close();
		List<Answers> answerList=new ArrayList<Answers>();
		while(resultSet.next()) {
			Answers answer=new Answers();
			answer.setAnswer(resultSet.getString("answer"));
			answer.setEmpUserId(resultSet.getString("a_username"));
			answerList.add(answer);
		}
		ConnectionManager.closeConnection();
		logger.info("---- In EmployeesDAOImpl getAllAnswers method completed ---- ");
		return answerList;
}
}

