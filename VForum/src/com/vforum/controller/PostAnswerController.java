package com.vforum.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;
import com.vforum.service.PostAnswerService;
import com.vforum.view.EmployeesView;

public class PostAnswerController {
	Logger logger=Logger.getLogger(PostAnswerController.class.getName());
	private PostAnswerService postAnswerService;
	EmployeesView employeesView=new EmployeesView();
	public PostAnswerController() {
		
		this.postAnswerService=
				FactoryEmployeeDB.createAnswerService();
	}
	public void postAnswer(PostAnswerModel answerModel,LoginModel loginModel)throws ClassNotFoundException,SQLException {
		logger.info("-----In PostAnswercontroller class postAnswer method called---");
		String outcome=postAnswerService. postAnswer(answerModel,loginModel);
		logger.info("In postAnswer method the value of outcome in PostAnswerController class is :"+outcome);
		if(outcome.contentEquals("success")) {
			logger.info("---- answer posted successfully ---- ");
			employeesView.showPostAnswerSuccess(answerModel,loginModel);	
		}else {
			logger.error("posting of answer failed");
			employeesView.showPostAnswerFailure(answerModel,loginModel);
		}
		logger.info("-----In PostAnswer controller class postAnswer method completed---");
}
}
