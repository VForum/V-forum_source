package com.vforum.service;

import java.sql.SQLException;

import com.vforum.dao.PostAnswerDAO;
import com.vforum.dao.PostQuestionDAO;
import com.vforum.entities.Answers;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;

public class PostAnswerServiceImpl implements PostAnswerService {

private PostAnswerDAO postAnswerDAO;
	
	public PostAnswerServiceImpl() {
		this.postAnswerDAO=FactoryEmployeeDB.createAnswerDAO();
		}
	@Override
	public String postAnswer(PostAnswerModel answerModel,LoginModel loginModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
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
			System.out.println("!ERROR[Posting of question failed because of internal issues...]");
		}
		return result;
	}

}
