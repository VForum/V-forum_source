package com.vforum.controller;
/*
 * this controller class will handle login authentication of users
 */
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.service.LoginService;
import com.vforum.view.AdminView;
import com.vforum.view.ErrorView;
import com.vforum.view.MainView;

public class FrontController {
	Logger logger=Logger.getLogger(FrontController.class.getName());
	private LoginService loginService;
	MainView mainView=new MainView();
	AdminView adminView=new AdminView();
	ErrorView errorView=new ErrorView();
	public FrontController() {
		this.loginService=
				FactoryEmployeeDB.createLoginService();
	}
	
	public void userAuthentication(String userId,String password)throws ClassNotFoundException,SQLException, IOException {
		logger.info("-----In Frontcontroller class userAuthentication method called---");
		LoginModel loginModel=new LoginModel();
		loginModel.setUserId(userId);
		loginModel.setPassword(password);
		
			String outcome=loginService.userAuthenticationService(loginModel);
			logger.info("In userAuthentication the value of outcome in Front Controller class is :"+outcome);
			if(outcome.contentEquals("ADMIN")){
			adminView.mainAdminView(loginModel);
			}
			else if(outcome.contentEquals("EMPLOYEE")) {
				mainView.employeeMenu(loginModel);
			}
		else {
			logger.error("Authentication failed");
			errorView.authenticationError();
		}
			logger.info("-----In Frontcontroller class userAuthentication method completed---");
	}	
}
