package com.vforum.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.service.AdminService;
import com.vforum.view.AdminView;


public class AdminController {

	private AdminService adminService;
	
	Logger logger=Logger.getLogger(AdminController.class.getName());
	
	AdminView adminView=new AdminView();
	
	public AdminController()
	{
	 this.adminService=FactoryAdminDB.createAdminService();
	}
	public void viewEmployees(LoginModel loginModel) {
		
		logger.info("-----In admincontroller class viewEmployees method called---");
		List<EmployeeModel> models=adminService.retrieveEmployees();
		adminView.showEmployees(models,loginModel);
		logger.info("-----viewEmployees method completed---");
	}
	public void viewQuestions(LoginModel loginModel) {
		logger.info("-----In admincontroller class viewQuestions method called---");
		List<PostModel> models=adminService.retrievePosts();
		logger.info("In viewQuestions method the models contains:"+models);
		adminView.showQuestions(models,loginModel);
		logger.info("-----In admincontroller viewQuestions method completed---");
	}
	public void deleteQuestion(LoginModel loginModel,int postId) {
		logger.info("-----In admincontroller class deleteQuestion method called---");
		String outcome=adminService.deleteQuestion(postId);
		logger.info("In deleteQuestion the value of outcome is :"+outcome);
		if(outcome.contentEquals("success")) {
		adminView.showQuestionDeleteSuccess(loginModel,postId); 
		}
		else {
			adminView.showQuestionDeleteUnSuccess(loginModel,postId); 
		}
		logger.info("-----In admincontroller deleteQuestion method completed---");
	}
}
