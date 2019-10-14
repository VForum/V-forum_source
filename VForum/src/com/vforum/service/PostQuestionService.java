package com.vforum.service;

import java.sql.SQLException;
import com.vforum.model.PostQuestionModel;


public interface PostQuestionService {

	public String postQuestion(PostQuestionModel postmodel)throws ClassNotFoundException,SQLException;
}
