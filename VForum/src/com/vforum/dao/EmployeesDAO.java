package com.vforum.dao;

import java.sql.SQLException;
import java.util.List;

import com.vforum.entities.Answers;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.model.LoginModel;


public interface EmployeesDAO {

	public boolean storeEmployeeDetails(Employees employees)throws ClassNotFoundException, SQLException;
	public List<Posts> getAllQuestions()throws ClassNotFoundException, SQLException;
	public List<Employees> getProfile(LoginModel loginModel)throws ClassNotFoundException, SQLException;
	public List<Answers> getAllAnswers(LoginModel loginModel,int postId)throws ClassNotFoundException, SQLException;

}
