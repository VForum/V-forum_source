package com.vforum.controller;

import java.sql.SQLException;
import java.util.List;

import com.vforum.entities.Employees;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.service.EmployeesService;
import com.vforum.validation.EmployeesModelValidator;
import com.vforum.view.EmployeesView;
import com.vforum.view.MainView;

public class EmployeeController {
	private EmployeesService employeeService;
	EmployeesView employeeView=new EmployeesView();
	
	public EmployeeController() {
		this.employeeService=
				FactoryEmployeeDB.createEmployeesService();
	}

	public void handleRegisterEmployee(RegisterEmployeeModel model) throws ClassNotFoundException, SQLException{
		
		EmployeesModelValidator validator=new EmployeesModelValidator();
				
		if(validator.validate(model)) {
		
		String outcome=employeeService.registerEmployee(model);
		if(outcome.contentEquals("success")) {
			employeeView.showRegistrationSuccess(model);	
		}else {
			employeeView.showRegistrationFailure(model);
		}
	}else {
		employeeView.validationFailedError();
	}
	}
	public void viewQuestions(LoginModel loginModel) {
		List<PostModel> models=employeeService.retrievePosts();
		MainView mainView=new MainView();
		employeeView.showQuestions(models,loginModel);
	}
}
