package com.vforum.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.dao.LoginDAO;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;

public class LoginServiceImpl implements LoginService{
	Logger logger=Logger.getLogger(LoginServiceImpl.class.getName());
	private LoginDAO loginDAO=null;
	
	public LoginServiceImpl() {
		this.loginDAO=FactoryEmployeeDB.createLoginDAO();
	}

	@Override
	public String userAuthenticationService(LoginModel loginModel)throws ClassNotFoundException,SQLException {
		logger.info("---- In LoginServiceImpl userAuthenticationService method started ---- ");
		logger.info("---- Passing parameters userid and password from loginmodel to userAuth method of loginDAO ---- ");
			String userValid=loginDAO.userAuth(loginModel.getUserId(),loginModel.getPassword());
			logger.info("---- In LoginServiceImpl userAuthenticationService method completed ---- ");
			return userValid;
	}

	
}
