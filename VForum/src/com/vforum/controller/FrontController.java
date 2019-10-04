package com.vforum.controller;

import java.sql.SQLException;

import com.vforum.exception.UserException;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.service.LoginService;
import com.vforum.view.EmployeesView;
//import com.vforum.view.EmployeesView;
import com.vforum.view.ErrorView;
import com.vforum.view.MainView;

public class FrontController {

	private LoginService loginService;
	MainView mainView=new MainView();
	public FrontController() {
		this.loginService=
				FactoryEmployeeDB.createLoginService();
	}
	
	public void userAuthentication(String userId,String password)throws ClassNotFoundException,SQLException {
		
		LoginModel loginModel=new LoginModel();
		loginModel.setUserId(userId);
		loginModel.setPassword(password);
		
			String outcome=loginService.userAuthenticationService(loginModel);
		if(outcome.contentEquals("success")){
			mainView.employeeMenu(loginModel);
		}
		else{
			mainView.viewEmployeeMainMenu();
		}
	}	
}
