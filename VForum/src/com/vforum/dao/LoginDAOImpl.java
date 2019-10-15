package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.integrate.ConnectionManager;

public class LoginDAOImpl implements LoginDAO {
	Logger logger=Logger.getLogger(LoginDAOImpl.class.getName());
	@Override
	public String userAuth(String userId, String password)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In LoginDAOImpl userAuth method started ---- ");
		String role="";
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- retrieving user role from database also authenticating login credentials---- ");
		String query2="select role from user_credentials where username=? and user_password=?";
		PreparedStatement preparedStatement2=connection.prepareStatement(query2);
		preparedStatement2.setString(1, userId);
		preparedStatement2.setString(2, password);
		ResultSet rs2 = preparedStatement2.executeQuery();
		while(rs2.next()) 
		role=rs2.getString("role");
		logger.info("---- In LoginDAOImpl userAuth method completed ---- ");
		return role;
			
		
	}
		

}
