package com.vforum.dao;

import java.sql.SQLException;
import java.util.List;

import com.vforum.entities.Employees;
import com.vforum.entities.Posts;

public interface AdminDAO {

	public  List<Employees> getEmployeeDetails() throws ClassNotFoundException,SQLException;
	public List<Posts> getAllQuestions()throws ClassNotFoundException, SQLException;
}
