package com.vforum.controller;

import java.util.List;

import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.LoginModel;
import com.vforum.model.RegisterEmployeeModel;
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
		List<RegisterEmployeeModel> models=adminService.retrieveEmployees();
		adminView.showEmployees(models,loginModel);
	}
}
