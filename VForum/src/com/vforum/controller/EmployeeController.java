package com.vforum.controller;

import java.sql.SQLException;
import java.util.List;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.AnswerModel;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.service.EmployeesService;
import com.vforum.validation.EmployeesModelValidator;
import com.vforum.view.EmployeesView;


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
		employeeView.showQuestions(models,loginModel);
	}
	public void viewProfile(LoginModel loginModel) {
		List<EmployeeModel> models=employeeService.getProfile(loginModel);
		employeeView.showProfile(models,loginModel);
	}
	public void viewAnswers(LoginModel loginModel,int postId) {
		List<AnswerModel> models=employeeService.retrieveAnswers(loginModel,postId);
		employeeView.showAnswers(models,loginModel);
	}
}
