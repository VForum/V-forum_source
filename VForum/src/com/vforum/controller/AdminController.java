package com.vforum.controller;

import java.util.List;

import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.service.AdminService;
import com.vforum.view.AdminView;


public class AdminController {

	private AdminService adminService;
	
	AdminView adminView=new AdminView();
	
	public AdminController()
	{
	 this.adminService=FactoryAdminDB.createAdminService();
	}
	public void viewEmployees(LoginModel loginModel) {
		List<EmployeeModel> models=adminService.retrieveEmployees();
		adminView.showEmployees(models,loginModel);
	}
	public void viewQuestions(LoginModel loginModel) {
		List<PostModel> models=adminService.retrievePosts();
		adminView.showQuestions(models,loginModel);
	}
	public void deleteQuestion(LoginModel loginModel,int postId) {
		String outcome=adminService.deleteQuestion(postId);
		adminView.showQuestionDeleteSuccess(loginModel,postId);
	}
}
