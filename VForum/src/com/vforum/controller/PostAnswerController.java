package com.vforum.controller;

import java.sql.SQLException;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;
import com.vforum.service.PostAnswerService;
import com.vforum.view.EmployeesView;

public class PostAnswerController {

	private PostAnswerService postAnswerService;
	EmployeesView employeesView=new EmployeesView();
	public PostAnswerController() {
		
		this.postAnswerService=
				FactoryEmployeeDB.createAnswerService();
	}
	public void postAnswer(PostAnswerModel answerModel,LoginModel loginModel)throws ClassNotFoundException,SQLException {
		
		String outcome=postAnswerService. postAnswer(answerModel,loginModel);
		if(outcome.contentEquals("success")) {
			employeesView.showPostAnswerSuccess(answerModel,loginModel);	
		}else {
			employeesView.showPostAnswerFailure(answerModel,loginModel);
		}
}
}
