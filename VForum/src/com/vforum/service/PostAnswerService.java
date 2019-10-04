package com.vforum.service;

import java.sql.SQLException;

import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;
import com.vforum.model.PostQuestionModel;

public interface PostAnswerService {

	public String postAnswer(PostAnswerModel answerModel,LoginModel loginModel)throws ClassNotFoundException,SQLException;
}
