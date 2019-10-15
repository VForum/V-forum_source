package com.vforum.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.dao.PostQuestionDAO;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.PostQuestionModel;

public class PostQuestionServiceImpl implements PostQuestionService {
	
	private PostQuestionDAO postQuestionDAO;
	Logger logger=Logger.getLogger(PostQuestionServiceImpl.class.getName());
	public PostQuestionServiceImpl() {
		this.postQuestionDAO=FactoryEmployeeDB.createQuestionDAO();
		}

	@Override
	public String postQuestion(PostQuestionModel model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In PostQuestionServiceImpl postQuestion method started ---- ");
		Posts posts=new Posts();
		posts.setPost(model.getPost());
		posts.setCategory(model.getTitle());
		posts.setUserId(model.getUserId());

		String result="fail";
		try {
			boolean stored=postQuestionDAO.storeQuestion(posts);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("!ERROR[Posting of question failed because of internal issues...]");
		}
		logger.info("---- In PostQuestionServiceImpl postQuestion method completed ---- ");
		return result;
	}

}
