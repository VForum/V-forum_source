package com.vforum.service;
/*
 * Service interface for posting answer
 */
import java.sql.SQLException;

import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;

public interface PostAnswerService {

	public String postAnswer(PostAnswerModel answerModel,LoginModel loginModel)throws ClassNotFoundException,SQLException;
}
