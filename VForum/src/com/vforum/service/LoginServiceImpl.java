package com.vforum.service;

import java.sql.SQLException;

import com.vforum.dao.LoginDAO;
import com.vforum.exception.UserException;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.view.EmployeesView;

public class LoginServiceImpl implements LoginService{
	
	private LoginDAO loginDAO=null;
	
	public LoginServiceImpl() {
		this.loginDAO=FactoryEmployeeDB.createLoginDAO();
	}

	@Override
	public String userAuthenticationService(LoginModel loginModel)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		
		String result="fail";
			boolean userValid=loginDAO.userAuth(loginModel.getUserId(),loginModel.getPassword());
			if(userValid){
				result="success";}
			else{
				EmployeesView employeesView=new EmployeesView();
				employeesView.showLoginFailure();
				 }
		
		return result;
	}

	
}
