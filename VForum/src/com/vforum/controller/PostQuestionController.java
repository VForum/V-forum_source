package com.vforum.controller;
/*
 * this controller will pass the post question from input to service
 */
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.service.PostQuestionService;
import com.vforum.view.EmployeesView;

public class PostQuestionController {
	Logger logger=Logger.getLogger(PostQuestionController.class.getName());
	private PostQuestionService postQuestionService;
	EmployeesView employeesView=new EmployeesView();
	public PostQuestionController() {
		
		this.postQuestionService=
				FactoryEmployeeDB.createQuestionService();
	}
	
		public void postQuestion(PostQuestionModel model,LoginModel loginModel)throws ClassNotFoundException,SQLException {
			logger.info("-----In PostQuestion controller class postQuestion method called---");
			String outcome=postQuestionService. postQuestion(model);
			logger.info("In postQuestion method the value of outcome in PostQuestion Controller class is :"+outcome);
			if(outcome.contentEquals("success")) {
				logger.info("---- question posted successfully ---- ");
				employeesView.showPostSuccess(model,loginModel);	
			}else {
				logger.error("posting of question failed");
				employeesView.showPostFailure(model,loginModel);
			}
			logger.info("-----In PostQuestion controller class postQuestion method completed---");
	}
}
