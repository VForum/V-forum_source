package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vforum.integrate.ConnectionManager;

public class LoginDAOImpl implements LoginDAO {

	String value1="EMPLOYEE";
	String value2="ADMIN";
	@Override
	public boolean userAuth(String userId, String password,int option)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		String query1;
		Connection connection=ConnectionManager.openConnection();
		if(option==1) {
		query1 = "select count(*) from admin where user_id=? AND user_password=?";}
		else {
			query1 = "select count(*) from employees where emp_uid=? AND password=?";}
		PreparedStatement preparedStatement1=connection.prepareStatement(query1);
			preparedStatement1.setString(1, userId);
			preparedStatement1.setString(2, password);
			ResultSet rs1 = preparedStatement1.executeQuery();
			rs1.next();
			if (rs1.getInt(1)>0) 
				return true;
			else
				return false;
	}
		

}
