package com.vforum.controller;

import java.sql.SQLException;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.service.PostQuestionService;
import com.vforum.view.EmployeesView;

public class PostQuestionController {
	private PostQuestionService postQuestionService;
	EmployeesView employeesView=new EmployeesView();
	public PostQuestionController() {
		
		this.postQuestionService=
				FactoryEmployeeDB.createQuestionService();
	}
	
		public void postQuestion(PostQuestionModel model,LoginModel loginModel)throws ClassNotFoundException,SQLException {
			
			String outcome=postQuestionService. postQuestion(model);
			if(outcome.contentEquals("success")) {
				employeesView.showPostSuccess(model,loginModel);	
			}else {
				employeesView.showPostFailure(model,loginModel);
			}
	}
}
