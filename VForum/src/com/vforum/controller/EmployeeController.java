package com.vforum.controller;
/**
 * This class controls the operations of employees
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

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
	Logger logger=Logger.getLogger(EmployeeController.class.getName());
	
	public EmployeeController() {
		this.employeeService=
				FactoryEmployeeDB.createEmployeesService();
	}

	public void handleRegisterEmployee(RegisterEmployeeModel model) throws ClassNotFoundException, SQLException, IOException{
		
		EmployeesModelValidator validator=new EmployeesModelValidator();
				
		if(validator.validate(model)) {
		
		String outcome=employeeService.registerEmployee(model);
		logger.info("In handleRegisterEmployee method the value of outcome in Employee Controller class is :"+outcome);
		if(outcome.contentEquals("success")) {
			employeeView.showRegistrationSuccess(model);	
		}else {
			employeeView.showRegistrationFailure(model);
		}
	}else {
		logger.error("employee registration failed");
		employeeView.registrationFailedError();
	}
	}
	public void viewQuestions(LoginModel loginModel) {
		logger.info("-----In employee controller class viewQuestions method called---");
		List<PostModel> models=employeeService.retrievePosts();
		employeeView.showQuestions(models,loginModel);
		logger.info("-----In employee controller class viewQuestions method completed---");
	}
	public void viewProfile(LoginModel loginModel) {
		logger.info("-----In employee controller class viewProfile method called---");
		List<EmployeeModel> models=employeeService.getProfile(loginModel);
		employeeView.showProfile(models,loginModel);
		logger.info("-----In employee controller class viewProfile method completed---");
	}
	public void viewAnswers(LoginModel loginModel,int postId) {
		logger.info("-----In employee controller class viewAnswers method called---");
		List<AnswerModel> models=employeeService.retrieveAnswers(loginModel,postId);
		employeeView.showAnswers(models,loginModel);
		logger.info("-----In employee controller class viewAnswers method completed---");
	}
}
