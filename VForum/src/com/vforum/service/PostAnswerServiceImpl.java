package com.vforum.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.dao.PostAnswerDAO;
import com.vforum.entities.Answers;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;

public class PostAnswerServiceImpl implements PostAnswerService {

	private PostAnswerDAO postAnswerDAO;
	Logger logger=Logger.getLogger(PostAnswerServiceImpl.class.getName());
	public PostAnswerServiceImpl() {
		this.postAnswerDAO=FactoryEmployeeDB.createAnswerDAO();
		}
	@Override
	public String postAnswer(PostAnswerModel answerModel,LoginModel loginModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In PostAnswerServiceImpl postAnswer method started ---- ");
		Answers answers=new Answers();
		answers.setAnswer(answerModel.getAnswer());
		answers.setPostId(answerModel.getPostId());
		answers.setEmpUserId(loginModel.getUserId());

		String result="fail";
		try {
			boolean stored=postAnswerDAO.storeAnswer(answers);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("!ERROR[Posting of question failed because of internal issues...]");
		}
		logger.info("---- In PostAnswerServiceImpl postAnswer method completed ---- ");
		return result;
	}

}
