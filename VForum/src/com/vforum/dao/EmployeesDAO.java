package com.vforum.dao;

import java.sql.SQLException;
import java.util.List;

import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.model.LoginModel;
//import com.vforum.model.ViewProfileModel;

public interface EmployeesDAO {

	public boolean storeEmployeeDetails(Employees employees)throws ClassNotFoundException, SQLException;
	public List<Posts> getAllQuestions()throws ClassNotFoundException, SQLException;

}
