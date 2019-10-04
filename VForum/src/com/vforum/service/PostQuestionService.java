package com.vforum.service;

import java.sql.SQLException;

import com.vforum.model.LoginModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;

public interface PostQuestionService {

	public String postQuestion(PostQuestionModel postmodel)throws ClassNotFoundException,SQLException;
}
