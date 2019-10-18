package com.vforum.service;
/*
 * Service interface for posting question
 */
import java.sql.SQLException;
import com.vforum.model.PostQuestionModel;


public interface PostQuestionService {

	public String postQuestion(PostQuestionModel postmodel)throws ClassNotFoundException,SQLException;
}
