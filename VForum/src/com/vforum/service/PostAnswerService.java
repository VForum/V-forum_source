package com.vforum.service;

import java.sql.SQLException;

import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;

public interface PostAnswerService {

	public String postAnswer(PostAnswerModel answerModel,LoginModel loginModel)throws ClassNotFoundException,SQLException;
}
