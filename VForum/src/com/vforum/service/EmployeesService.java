package com.vforum.service;

import java.sql.SQLException;
import java.util.List;

import com.vforum.model.AnswerModel;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.RegisterEmployeeModel;
//import com.vforum.model.ViewProfileModel;

public interface EmployeesService {

	public String registerEmployee(RegisterEmployeeModel model)throws ClassNotFoundException,SQLException;
	public List<PostModel> retrievePosts();
	public List<AnswerModel> retrieveAnswers(LoginModel loginModel,int postId);
	public List<EmployeeModel> getProfile(LoginModel loginModel);
	
}